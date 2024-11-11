import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<Customer>() ;

        customers.add(new Customer("홍길동", 150)) ;
        customers.add(new Customer("우수한", 350)) ;
        customers.add(new Customer("부족한", 50)) ;
        customers.add(new Customer("훌륭한", 450)) ;
        customers.add(new Customer("최고의", 550)) ;

//        SimpleReportGenerator simpleGenerator = new SimpleReportGenerator() ;
        ComplexReportGenerator complexReportGenerator = new ComplexReportGenerator();
        System.out.println(complexReportGenerator.generate(customers)) ;
    }
}

