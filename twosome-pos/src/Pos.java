public class Pos {
    int postNo;
    boolean isPos;
    int cardTotal = 0;
    int cashTotal = 0;
    int qrTotal = 0;
    int total = 0;
    DiscountStrategy discountStrategy;

    public Pos(int postNo, boolean isPos) {
        this.postNo = postNo;
        this.isPos = isPos;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public int getTotal() {
        return total;
    }

    public int calculateDiscount(Menu menu, DiscountStrategy discountStrategy, Integer percent, Integer amount) {

        return  discountStrategy.discount(menu.getPrice(), percent, amount);

    }

    public void menuSoldOut(Menu menu) {
        menu.setToSoldOut();
    }

    public void menuStored(Menu menu) {
        menu.setToStored();
    }
}
