import java.util.List;

public class Pos implements MenuObserver{
    int postNo;
    boolean isPos;
    int cardTotal = 0;
    int cashTotal = 0;
    int qrTotal = 0;
    int total = 0;
    List<Menu> menus;

    DiscountGenerator discountGenerator;

    public Pos(int postNo, boolean isPos) {
        this.postNo = postNo;
        this.isPos = isPos;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setDiscountStrategy(DiscountGenerator discountGenerator) {
        this.discountGenerator = discountGenerator;
    }

    public int getTotal() {
        return total;
    }

    public int calculateDiscount(Menu menu) {
        return discountGenerator.discount(menu);
    }

    public void menuSoldOut(Menu menu) {
        menu.setToSoldOut();
    }

    public void menuStored(Menu menu) {
        menu.setToStored();
    }
    public void addMenus(List<Menu> menus) {
        this.menus = menus;
        for (Menu menu : menus) {
            menu.attach(this);
        }
    }

    @Override
    public void update(Menu menu, Boolean isSoldOut) {
        for (Menu m : menus) {
            if (m.getName().equals(menu.getName()) &&
                    m.getSize() == menu.getSize() &&
                    m.getCategory() == menu.getCategory()) {
                m.isSoldOut = isSoldOut;
            }
        }
    }
}
