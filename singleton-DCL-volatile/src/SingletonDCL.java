public class SingletonDCL {
    private volatile static SingletonDCL instance;

    private SingletonDCL() {
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public static SingletonDCL getInstance() {
        // First check (no locking)
        if (instance == null) {
            // Synchronize on class object
            synchronized (SingletonDCL.class) {
                // Second check (with locking)
                if (instance == null) {
                    // Create the instance
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Singleton is doing something.");
    }

    // Main method for demonstration
    public static void main(String[] args) {
        SingletonDCL singleton = SingletonDCL.getInstance();
        SingletonDCL singleton2 = SingletonDCL.getInstance();
        singleton.doSomething();
        singleton2.doSomething();

        System.out.println("singleton = " + singleton);
        System.out.println("singleton2 = " + singleton2);
    }
}