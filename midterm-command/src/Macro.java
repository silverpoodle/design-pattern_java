import java.util.Iterator;
import java.util.Stack;

class Macro implements Order {
    private Stack<Order> orders = new Stack<>();


    public void do1() {
        Iterator<Order> it = orders.iterator();
        while(it.hasNext()) {
            it.next().do1();
        }
    }

    public void append(Order order) {
        if(order != this) {
            orders.push(order);
        }
    }

    public void do2() {
        if (!orders.isEmpty()) {
            orders.pop().do2();
        }
    }

    public void clear() {
        orders.clear();
    }
}





