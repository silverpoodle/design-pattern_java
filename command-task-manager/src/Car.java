public class Car {
    private boolean engineOn = false;
    public void power() {
        engineOn = !engineOn;
        if (engineOn)
            System.out.print("Start");
        else
            System.out.print("Stop");
    }
}