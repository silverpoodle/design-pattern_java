public class Main {

    /**
    SINGLETON PATTERN <br/><br/>
     1.

    * */
    public static void main(String[] args) {
//        Logger logger1 = new Logger();
        Account acc1 = new Account("JUNGIN", 50000);
//        acc1.setMyLogger(logger1);
        acc1.deposit(5000);

//        Logger logger2 = new Logger();
        Account acc2 = new Account("SUI", 10000);
//        acc2.setMyLogger(logger2);
        acc2.withdraw(3000);
    }
}