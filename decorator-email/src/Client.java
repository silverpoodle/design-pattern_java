public class Client {
    public static void main(String[] args) {
        BasicEmailContent simple = new BasicEmailContent("Hello") ;
        System.out.println(simple.getContent()) ;

        ExternalEmailContent external = new ExternalEmailContent("Hello");
        System.out.println(external.getContent()) ;

        SecureEmailContent secure = new SecureEmailContent("Hello") ;
        System.out.println(secure.getContent()) ;
    }
}
