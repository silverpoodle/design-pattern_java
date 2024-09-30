public class Employee {
    private int id;
    private String name;
    private int hoursWorked;
    private int overTimeHours;
    private PayStrategy payStrategy;

    public double calculatePay() {
        return payStrategy.calculatePay(hoursWorked, overTimeHours);
    }

    public void setPayStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public Employee(int id, String name, int hoursWorked, int overTimeHours) {
        this.id = id;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.overTimeHours = overTimeHours;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getOverTimeHours() {
        return overTimeHours;
    }

    public void setOverTimeHours(int overTimeHours) {
        this.overTimeHours = overTimeHours;
    }
}
