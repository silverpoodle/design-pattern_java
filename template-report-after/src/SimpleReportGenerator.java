import java.util.List;

public class SimpleReportGenerator extends ReportGenerator{
    @Override
    protected boolean checkCustomer(Customer customer) {
        return true;
    }

    @Override
    protected String getHeader(List<Customer> customers) {
        return "고객의 수: " + customers.size() + "명\n";
    }

    @Override
    protected String getBodyForCustomer(Customer customer) {
        return customer.getName() + " : " + customer.getPoint() + "\n";
    }

    @Override
    protected String getFooter(List<Customer> customers) {
        return "";
    }
}
