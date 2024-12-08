import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Client client1 = new Client("01012341234", "321321321");
        Client client2 = new Client(null, "123123123");
        Client client3 = new Client(null, null);

        List<Menu> menus = Arrays.asList(
                new Menu("아메리카노", Size.REGULAR, 4500, Category.COFFEE),
                new Menu("카페라떼", Size.REGULAR, 5000, Category.COFFEE),
                new Menu("바닐라라떼", Size.REGULAR, 5500, Category.COFFEE),
                new Menu("카라멜마키아또", Size.REGULAR, 5800, Category.COFFEE),
                new Menu("카페모카", Size.REGULAR, 5500, Category.COFFEE),
                new Menu("에스프레소", Size.REGULAR, 4000, Category.COFFEE),
                new Menu("콜드브루", Size.REGULAR, 5000, Category.COFFEE),
                new Menu("플랫화이트", Size.REGULAR, 5000, Category.COFFEE),

                new Menu("얼그레이", Size.REGULAR, 4500, Category.TEA),
                new Menu("캐모마일", Size.REGULAR, 4500, Category.TEA),
                new Menu("페퍼민트", Size.REGULAR, 4500, Category.TEA),
                new Menu("초콜릿", Size.REGULAR, 5000, Category.DRINKS),
                new Menu("녹차라떼", Size.REGULAR, 5500, Category.DRINKS),
                new Menu("딸기스무디", Size.REGULAR, 6000, Category.BLENDED),
                new Menu("망고스무디", Size.REGULAR, 6000, Category.BLENDED),
                new Menu("요구르트스무디", Size.REGULAR, 6000, Category.BLENDED),

                new Menu("티라미수", Size.REGULAR, 6500, Category.CAKE),
                new Menu("뉴욕치즈케이크", Size.REGULAR, 6500, Category.CAKE),
                new Menu("초콜릿케이크", Size.REGULAR, 6500, Category.CAKE),
                new Menu("레드벨벳케이크", Size.REGULAR, 6500, Category.CAKE),
                new Menu("당근케이크", Size.REGULAR, 6500, Category.CAKE)
        );

        Pos pos1 = new Pos(1, true );
        Pos pos2 = new Pos(2, true );

        pos1.addMenus(menus);
        pos2.addMenus(menus);

        System.out.println("pos1 cnt = " + pos1.getMenus().get(3).isSoldOut);
        System.out.println("pos2 cnt = " + pos2.getMenus().get(3).isSoldOut);

        pos1.menuSoldOut(menus.get(3));

        System.out.println("pos1 cnt = " + pos1.getMenus().get(3).isSoldOut);
        System.out.println("pos2 cnt = " + pos2.getMenus().get(3).isSoldOut);

        pos2.menuStored(menus.get(3));

        System.out.println("pos1 cnt = " + pos1.getMenus().get(3).isSoldOut);
        System.out.println("pos2 cnt = " + pos2.getMenus().get(3).isSoldOut);

        DiscountGenerator discountStrategy1 = new SktDiscount();
        DiscountGenerator discountStrategy2 = new PercentDiscount(10);

        pos1.setDiscountStrategy(discountStrategy1);
        pos2.setDiscountStrategy(discountStrategy2);

        pos1.calculateDiscount(menus.get(0));
        pos1.calculateDiscount(menus.get(1));

        System.out.println(pos1.getTotal());


    }
}