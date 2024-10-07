public class PowerButtonCtrl implements Controller{

    private TV tv;

    public PowerButtonCtrl(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        System.out.println("Power" + (tv.isPowerOn() ? "OFF" : "ON"));
        tv.setPowerOn(!tv.isPowerOn());
    }
}
