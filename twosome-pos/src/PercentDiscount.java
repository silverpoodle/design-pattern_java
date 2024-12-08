public class PercentDiscount extends DiscountGenerator {
    private final int percent;

    public PercentDiscount(int percent) {
        this.percent = percent;
    }

    @Override
    protected int discount(Menu menu) {
        return (int) (menu.getPrice() * (percent/100));
    }
}
