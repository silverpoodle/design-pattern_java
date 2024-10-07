public class TvPowerCmd implements Command{
    private TV tvReceiver;
    public TvPowerCmd(TV tvReceiver) {
        this.tvReceiver = tvReceiver;
    }
    public void execute() {
        tvReceiver.power();
    }
}
