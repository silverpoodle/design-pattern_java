public class Discount {

    String name;
    Integer percent;
    Integer amount;

    public Discount(String name, Integer percent, Integer amount) {
        this.name = name;
        this.percent = percent;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getPercent() {
        return percent;
    }

    public int getAmount() {
        return amount;
    }
}
