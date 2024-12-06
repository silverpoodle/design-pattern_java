import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Pos pos1 = new Pos(1, true );
        Pos pos2 = new Pos(2, true );

        Client client1 = new Client("01012341234", "321321321");
        Client client2 = new Client(null, "123123123");
        Client client3 = new Client(null, null);

        Menu americano = new Menu("AMERICANO", Size.REGULAR, 4500, Category.COFFEE);
        Menu latte = new Menu("LATTE", Size.REGULAR, 5000, Category.COFFEE);

        Discount discount1 = new Discount("SKT 우주패스", null, null);
        Pay pay1 = new Pay(PayMethod.CARD, client1);
        pos1.calculate(americano, discount1, pay1);

        System.out.println(pos1.getTotal());

        pos1.menuSoldOut(latte);
        pos2.menuSoldOut(latte);
        pos1.calculate(latte, discount1, pay1);

        pos1.menuStored(latte);
        pos2.menuStored(latte);
        pos1.calculate(latte, null, pay1);

        System.out.println(pos1.getTotal());


    }
}