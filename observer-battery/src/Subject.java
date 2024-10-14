import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();
    public void addObservers(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for(Observer observer : observers) {

        }
    }
}
