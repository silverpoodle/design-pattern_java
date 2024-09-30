public class PremiumPayStrategy implements PayStrategy{

    public double calculatePay(int hoursWorked, int overTimeHours) {
        return 20000 * hoursWorked + 40000 * overTimeHours;
    }
}
