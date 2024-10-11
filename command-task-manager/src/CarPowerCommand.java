public class CarPowerCommand implements Command {
    private Car car;

    public CarPowerCommand(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        car.power();
    }
}