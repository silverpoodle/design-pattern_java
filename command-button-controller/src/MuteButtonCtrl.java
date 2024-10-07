public class MuteButtonCtrl implements Controller{

    private TV tv;

    public MuteButtonCtrl(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        System.out.println("Mute" + (tv.isMuteOn() ? "OFF" : "ON"));
        tv.setMuteOn(!tv.isMuteOn());
    }
}
