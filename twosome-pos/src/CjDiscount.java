public class CjDiscount extends DiscountGenerator {
    @Override
    public int discount(Menu menu) {
        return (int) (menu.getPrice() * 0.7);
    }
}