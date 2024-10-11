public class Main {
    public static void main(String[] args) {

//        Car car1 = new Car();
//        Car car2 = new Car();
//        Command task1 = new CarPowerCommand(car1);
//        Tv tv = new Tv();
//        Command task2 = new TvMuteCommand(tv);
//        Command task3 = new CarPowerCommand(car2);
//        Command task4 = new TvMuteCommand(tv);
//
//        TaskManager manager = new TaskManager();
//        manager.addTask(task1);
//        manager.addTask(task2);
//        manager.addTask(task3);
//        manager.addTask(task4);
//
//        manager.runTasks();

//        Car car = new Car();
//
//        Command task1 = new CarPowerCommand(car);
//        Tv tv = new Tv();
//        Command task2 = new TvMuteCommand(tv);
//        Command task3 = new CarPowerCommand(car);
//        Command task4 = new TvMuteCommand(tv);
//
//        TaskManager manager = new TaskManager();
//        manager.addTask(task1);
//        manager.addTask(task2);
//        manager.addTask(task3);
//        manager.addTask(task4);
//
//        manager.runTasks();

        Command task1 = new CarPowerCommand(new Car());
        Command task2 = new CarPowerCommand(new Car());
        Command task3 = new CarPowerCommand(new Car());
        Command task4 = new CarPowerCommand(new Car());

        TaskManager manager = new TaskManager();
        manager.addTask(task1);
        manager.addTask(task2);
        manager.addTask(task3);
        manager.addTask(task4);

        manager.runTasks();

    }
}