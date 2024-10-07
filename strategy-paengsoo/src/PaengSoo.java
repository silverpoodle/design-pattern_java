public class PaengSoo {

    private Mode mode;
    public void setMode(Mode mode) {
        this.mode = mode;
    }
    public String printMode() {
        return mode.ModePrinter();
    }
}
