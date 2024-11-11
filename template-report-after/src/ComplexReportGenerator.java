import java.util.List;

public class ComplexReportGenerator extends ReportGenerator{
    @Override
    protected boolean checkCustomer(Customer customer) {
        if (customer.getPoint() >= 100) return true;
        else return false;
    }

    @Override
    protected String getHeader(List<Customer> customers) {
        int cnt = 0;
        for (Customer customer : customers) {
            if (customer.getPoint() >= 100) cnt++;
        }

        return "고객의 수 : " + cnt + "명\n";
    }

    @Override
    protected String getBodyForCustomer(Customer customer) {

        if (customer.getPoint() >= 100) return "고객의 수 : " + customer.getPoint() + "\n";
        else return "";
    }

    @Override
    protected String getFooter(List<Customer> customers) {
        int totalPoints = 0;
        for (Customer customer : customers) {
            if (customer.getPoint() >= 100) totalPoints += customer.getPoint();
        }

        return "점수 합계 : " + totalPoints + "점";
    }
}
