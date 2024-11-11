import java.util.List;

class SimpleReportGenerator {
    public String generate(List<Customer> customers) {
        String report = String.format("고객의 수: %d 명\n", customers.size()) ;
        for ( Customer customer : customers) {
            report += String.format("%s: %d\n", customer.getName(), customer.getPoint()) ;
        }
        return report ;
    }

}