import java.util.ArrayDeque;
import java.util.Queue;

public class TaskManager {
    private Queue<Command> taskQueue = new ArrayDeque<>();

    public void addTask(Command task) {
        taskQueue.offer(task);
    }

    public void runTasks() {
        while (!taskQueue.isEmpty()) {
            Command task = taskQueue.poll();
            task.execute();
        }
    }
}