public class Pay {

    PayMethod payMethod;
    Client client;

    public Pay(PayMethod payMethod, Client client) {
        this.payMethod = payMethod;
        this.client = client;
    }
}
