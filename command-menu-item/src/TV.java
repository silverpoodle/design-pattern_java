public class TV {

    private boolean isPowerOn = false;

    public void power() {
        System.out.println("TV power" + (isPowerOn ? " OFF" : " ON"));
        isPowerOn = !isPowerOn;
    }
}
