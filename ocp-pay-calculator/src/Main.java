public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "baboSUI", 100, 30);
        emp1.setPayStrategy(new BasicPayStrategy());
        System.out.println(emp1.calculatePay());

        Employee emp2 = new Employee(2, "baboRagu", 100, 50);
        emp2.setPayStrategy(new PremiumPayStrategy());
        System.out.println(emp2.calculatePay());


    }
}