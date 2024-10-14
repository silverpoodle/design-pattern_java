public class Main {
    public static void main(String[] args) {
        Battery battery = new Battery();

        BatteryLevelDisplay batteryDisplay = new BatteryLevelDisplay(battery);
        LowBatteryWarning lowBatteryWarning = new LowBatteryWarning(battery);
        BatteryNeedsCharging needsCharging = new BatteryNeedsCharging(battery);
        battery.addObservers(batteryDisplay);
        battery.addObservers(lowBatteryWarning);
        battery.addObservers(needsCharging);

//        battery.setDisplay(batteryDisplay);
//        battery.setWarning(lowBatteryWarning);
//        battery.setNeedsCharging(needsCharging);

        battery.consume(20);
        battery.consume(50);
        battery.consume(25);
    }
}
