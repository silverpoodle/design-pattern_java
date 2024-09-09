import java.util.Optional;


/**
 * TicketManager 클래스는 특정 수 (LIMITS)만큼 Ticket을 발행하는 클래스이다. <br/>
 * • 단일쓰레드 환경에서 실행될 때 코드의 문제점은?<br/>
 * • 문제점을 해결하기 위해 코드를 변경하라.<br/>
 * • 해결책이 다중 쓰레드에서 어떤 문제점이 발생하는가?<br/>
 * **/

public class Main {
    public static void main(String[] args) {
        TicketManager tm1 = new TicketManager();
        Optional<Ticket> t1 = tm1.issue();
        t1.ifPresent(s->System.out.println(s.getSerialNum()));

        Optional<Ticket> t2 = tm1.issue();
        t2.ifPresent(s->System.out.println(s.getSerialNum()));

        Optional<Ticket> t3 = tm1.issue();
        t3.ifPresent(s->System.out.println(s.getSerialNum()));

        TicketManager tm2 = new TicketManager();
        Optional<Ticket> t4 = tm2.issue();
        t4.ifPresent(s->System.out.println(s.getSerialNum()));
    }
}
