public class Main {
    public static void main(String[] args) {

        Pos pos1 = new Pos(1, true );
        Pos pos2 = new Pos(2, true );

        Client client1 = new Client("01012341234", "321321321");
        Client client2 = new Client(null, "123123123");
        Client client3 = new Client(null, null);

        Menu americano = new Menu("AMERICANO", Size.REGULAR, 4500, Category.COFFEE);
        Menu latte = new Menu("LATTE", Size.REGULAR, 5000, Category.COFFEE);

//        Discount discount1 = new Discount("SKT 우주패스", null, null);
        DiscountStrategy discountStrategy1 = new SktDiscountStrategy();
        DiscountStrategy discountStrategy2 = new PercentDiscountStrategy();

        pos1.calculateDiscount(americano, discountStrategy1, null, null);
        pos1.calculateDiscount(americano, discountStrategy2, 30, null);

        System.out.println(pos1.getTotal());


    }
}