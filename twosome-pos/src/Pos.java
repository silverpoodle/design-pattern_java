public class Pos {
    int postNo;
    boolean isPos;
    int cardTotal = 0;
    int cashTotal = 0;
    int qrTotal = 0;
    int total = 0;

    public Pos(int postNo, boolean isPos) {
        this.postNo = postNo;
        this.isPos = isPos;
    }

    public int getTotal() {
        return total;
    }

    public void calculate(Menu menu, Discount discount, Pay pay) {

        int profit = 0;

        if(menu.isSoldOut) {
            System.out.println("품절처리된 메뉴입니다.");
            return;
        }

        if(discount == null) {
            profit += menu.getPrice();
        }
        else if (discount.getName().equals("SKT 우주패스")) {
            profit += (int) (menu.getPrice() * 0.7);
        }
        else if (discount.getName().equals("CJ 임직원 할인")) {
            profit += (int) (menu.getPrice() * 0.7);
        }
        else if (discount.getName().equals("퍼센트 할인")) {
            profit += (int) (menu.getPrice() * discount.getPercent());
        }
        else if (discount.getName().equals("금액 할인")) {
            profit += (menu.getPrice() - discount.getAmount());
        }

        if (pay.payMethod == PayMethod.CARD) {
            cardTotal += profit;
        }

        if (pay.payMethod == PayMethod.CASH) {
            cashTotal += profit;
        }

        if (pay.payMethod == PayMethod.QR) {
            qrTotal += profit;
        }

        total += profit;

    }

    public void menuSoldOut(Menu menu) {
        menu.setToSoldOut();
    }

    public void menuStored(Menu menu) {
        menu.setToStored();
    }
}
