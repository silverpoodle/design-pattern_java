public class Account {

    private String owner;
    private int balance;
    private Logger myLogger;

    public Account(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
        this.myLogger = new Logger();
    }

    public int getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public void deposit(int money) {
        balance += money;
        myLogger.log("{owner: " + owner + ", Deposit: " + money + "}");
    }

    public void withdraw(int money) {
        balance -= money;
        myLogger.log("{owner: " + owner + ", Withdraw: " + money+ "}");
    }
}
