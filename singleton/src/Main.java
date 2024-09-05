public class Main {

    /**
    SINGLETON PATTERN <br/><br/>
     1.

    * */
    public static void main(String[] args) {
        Account acc1 = new Account("JUNGIN", 50000);
        acc1.deposit(5000);
        Account acc2 = new Account("SUI", 10000);
        acc2.withdraw(3000);
    }
}