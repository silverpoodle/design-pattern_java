public class TvMuteCommand implements Command {
    private Tv tv;

    public TvMuteCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.mute();
    }
}