import java.util.ArrayList;
import java.util.List;

abstract class ReportGenerator {

    private List<Customer> select(List<Customer> customers) {
        List<Customer> selected = new ArrayList<>();

        for (Customer customer : customers) {
            if (checkCustomer(customer)) selected.add(customer);
        }

        return selected;
    }

    protected abstract boolean checkCustomer(Customer customer);
    protected abstract String getHeader(List<Customer> customers);
    protected abstract String getBodyForCustomer(Customer customer);
    protected abstract String getFooter(List<Customer> customers);

    public String generate(List<Customer> customers) {

        List<Customer> selected;
        selected = select(customers);
        String report = getHeader(selected);

        for (Customer customer : customers) {
            report += getBodyForCustomer(customer);
        }

        report += getFooter(selected);

        return report;
    }
}
