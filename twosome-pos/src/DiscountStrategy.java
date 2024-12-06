public interface DiscountStrategy {
    int discount(int price, Integer percent, Integer amount);
}
