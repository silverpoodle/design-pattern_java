public class Main {
    public static void main(String[] args) {
        TV tv1 = new TV();
        TV tv2 = new TV();

        Controller controller1 = new PowerButtonCtrl(tv1);
        Controller controller2 = new PowerButtonCtrl(tv2);

        TwoButtonController twoButtonController = new TwoButtonController();
        twoButtonController.setCtrl1(controller1);
        twoButtonController.setCtrl2(controller2);

        twoButtonController.buttonPressed1();
        twoButtonController.buttonPressed2();
    }
}