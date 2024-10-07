public class MenuItem {

//    private Paengsoo paengsoo;
//    private TV tv;

//    public void buttonPressed(Object o) {
//        if(o instanceof Paengsoo) ((Paengsoo) o).jump();
//        else if (o instanceof TV) ((TV) o).power();
//    }

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonPressed() {
        command.execute();
    }
}
