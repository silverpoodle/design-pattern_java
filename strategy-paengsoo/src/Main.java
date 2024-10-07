public class Main {
    public static void main(String[] args) {
        PaengSoo paengSoo1 = new PaengSoo();
        paengSoo1.setMode(new WalkMode());
        System.out.println(paengSoo1.printMode());

        paengSoo1.setMode(new JumpMode());
        System.out.println(paengSoo1.printMode());
    }
}