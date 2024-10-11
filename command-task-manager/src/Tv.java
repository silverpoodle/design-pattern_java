public class Tv {
    private boolean muteOn = false;
    public void mute() {
        muteOn = !muteOn;
        if (muteOn)
            System.out.print("On");
        else
            System.out.print("Off");
    }
}