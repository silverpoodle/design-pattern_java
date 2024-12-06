public class PercentDiscountStrategy implements DiscountStrategy{
    @Override
    public int discount(int price, Integer percent, Integer amount) {
        return (int) (price * (percent/100));
    }
}
