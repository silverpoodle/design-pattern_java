public class PriceDiscount extends DiscountGenerator {
    private final int price;

    public PriceDiscount(int price) {
        this.price = price;
    }

    @Override
    protected int discount(Menu menu) {
        return menu.getPrice() - price;
    }
}
