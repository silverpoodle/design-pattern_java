public class SktDiscountStrategy implements DiscountStrategy{
    @Override
    public int discount(int price, Integer percent, Integer amount) {
        return (int) (price * 0.7);
    }
}
