public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new Thread(() -> printer.print1());
        Thread t2 = new Thread(() -> printer.print2());

        t1.start();
        t2.start();
    }
}