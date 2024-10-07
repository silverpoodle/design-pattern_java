public class TV {

    private Controller controller;
    private boolean powerOn = false;
    private boolean muteOn = false;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }

    public void setMuteOn(boolean muteOn) {
        this.muteOn = muteOn;
    }

    public boolean isPowerOn() {
        return powerOn;
    }

    public boolean isMuteOn() {
        return muteOn;
    }

    public void buttonPressed() {
        controller.execute();
    }


}