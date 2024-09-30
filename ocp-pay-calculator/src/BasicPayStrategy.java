public class BasicPayStrategy implements PayStrategy {
    public double calculatePay(int hoursWorked, int overTimeHours) {
        return 10000 * hoursWorked + 20000 * overTimeHours;
    }
}
