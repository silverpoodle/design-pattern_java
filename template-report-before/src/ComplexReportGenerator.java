import java.util.List;

public class ComplexReportGenerator {

    public String generate(List<Customer> customers) {

        int cnt = 0;
        int totalPoints = 0;

        String report = "";
        for ( Customer customer : customers) {
            if (customer.getPoint() >= 100){
                cnt ++;
                totalPoints += customer.getPoint();
                report += String.format("%s: %d\n", customer.getName(), customer.getPoint()) ;
            }
        }
        return "고객의 수: " + cnt +  "명\n" + report + "점수합계 : " + totalPoints;
    }


}
