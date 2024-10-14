import java.util.ArrayList;
import java.util.List;

public class Battery extends Subject{
    private int level = 100;

    /** 양방향 연관.
     * 배터리 양 display 하는 다양한 방식 추가 될 수 있음 -> 기존 코드 변경 필요 ⚠
     *
     * 양방향 -> 단방향 2개로!
     */

//    private List<Observer> observers = new ArrayList<>();

//    public void addObservers(Observer observer) {
//        observers.add(observer);
//    }

    //    private BatteryLevelDisplay display;
    //    private LowBatteryWarning warning;
    //    private BatteryNeedsCharging needsCharging;

    //    public void setDisplay(BatteryLevelDisplay display) {
    //        this.display = display;
    //    }
    //    public void setWarning(LowBatteryWarning warning) {
    //        this.warning = warning;
    //    }
    //    public void setNeedsCharging(BatteryNeedsCharging needsCharging) {
    //        this.needsCharging = needsCharging;
    //    }
    public void consume(int amount) {
        level -= amount;
        notifyObservers();
//
//        for(Observer observer : observers) {
//            observer.update();
//        }

    //        display.update();
    //        warning.update();
    //        needsCharging.update();
    }
    public int getLevel() {
        return level;
    }
}
