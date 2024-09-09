import java.util.Optional;

import static java.lang.Thread.sleep;

public class TicketManager {
    private static TicketManager instance;
    private int count;
    private final int LIMITS = 2;
    private TicketManager() {
        count = 0;
    }
    public static  TicketManager getInstance() {
        if (instance == null) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            instance = new TicketManager();
        }
        return instance;
    }
    public  Optional<Ticket> issue() {
        if (count >= LIMITS) return Optional.empty();
        Ticket t = new Ticket(count);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }
        count++;
//
        return Optional.of(t);
//        return Optional.of(new Ticket(count++));
    }
}
