public class Temp {
    private static Temp t;
    private int m;
    public static Temp getTemp() {
        if (t == null) t = new Temp();
        return t;
    }

    public int doIt(int i) {
        m += i;
        return m;
    }
}