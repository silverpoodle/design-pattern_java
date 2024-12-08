import java.util.List;

public class Menu extends MenuSubject{

    String name;
    Size size;
    int price;
    Category category;
    volatile boolean isSoldOut = false;

    public synchronized void setToSoldOut() {
        synchronized (MUTEX) {
            this.isSoldOut = true;
            notifyObservers(this, isSoldOut);
        }
    }

    public synchronized void setToStored() {
        synchronized (MUTEX) {
            this.isSoldOut = false;
            notifyObservers(this, isSoldOut);
        }
    }

    public Menu(String name, Size size, int price, Category category) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }


}
