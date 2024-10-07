public class TwoButtonController {

//    private TV tv;
//    public TwoButtonController(TV tv) { this.tv = tv;}
//    public void button1Pressed() { tv.power();}
//    public void button2Pressed() { tv.mute();}

    Controller ctrl1;
    Controller ctrl2;

    public void setCtrl1(Controller ctrl1) {
        this.ctrl1 = ctrl1;
    }

    public void setCtrl2(Controller ctrl2) {
        this.ctrl2 = ctrl2;
    }

    public void buttonPressed1(){
        ctrl1.execute();
    }
    public void buttonPressed2(){
        ctrl2.execute();
    }
}
