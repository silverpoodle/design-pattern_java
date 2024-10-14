public class BatteryNeedsCharging {
    private static final int NEEDS_CHARGING = 10;
    private Battery battery;
    public BatteryNeedsCharging(Battery battery) {
        this.battery = battery;
    }
    public void update() {
        int level = battery.getLevel();
        if (level < NEEDS_CHARGING)
            System.out.println(
                "<Warning> Battery NEEDS CHARGING: " + level
            );
    }
}
