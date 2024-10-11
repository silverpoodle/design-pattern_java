public class Printer {
    public Printer() {
    }

    public synchronized static void print1() {
        for (int i = 0; i < 3; i++)
            System.out.print(i);
    }

    public synchronized void print2() {
        for (int i = 3; i < 6; i++)
            System.out.print(i);

    }

    public static void main(String[] args) {
        Printer printer = new Printer();

        new Thread(() -> {
            Printer.print1();
        }).start();

        new Thread(() -> {
            printer.print2();
        }).start();
    }
}