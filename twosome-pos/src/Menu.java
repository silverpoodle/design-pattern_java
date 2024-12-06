import java.util.List;

public class Menu {

    String name;
    Size size;
    int price;
    Category category;
    List<Integer> gridXY;

    public void setToSoldOut() {
        isSoldOut = true;
    }

    public void setToStored() {
        isSoldOut = false;
    }

    boolean isSoldOut = false;

    public Menu(String name, Size size, int price, Category category, List<Integer> gridXY) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.category = category;
        this.gridXY = gridXY;
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

    public List<Integer> getGridXY() {
        return gridXY;
    }


}
