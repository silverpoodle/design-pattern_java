import java.util.ArrayList;
import java.util.List;

abstract class MenuSubject {
    private final List<MenuObserver> menuObservers = new ArrayList<>();
    protected final Object MUTEX = new Object();

    void attach(MenuObserver observer) {
        synchronized (MUTEX) {
            menuObservers.add(observer);
        }
    }

    void detach(MenuObserver observer) {
        synchronized (MUTEX) {
            menuObservers.remove(observer);
        }
    }

    void notifyObservers(Menu menu, boolean isSoldOut) {
        List<MenuObserver> observersCopy;
        synchronized (MUTEX) {
            observersCopy = new ArrayList<>(menuObservers);
        }
        for (MenuObserver observer : observersCopy) {
            observer.update(menu, isSoldOut);
        }
    }
}
