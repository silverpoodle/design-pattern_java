import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {
    private static FileLogger instance;
    private static final String LOG_FILE = "twosome.log";
    private PrintWriter writer;

    private FileLogger() {
        try {
            FileWriter fileWriter = new FileWriter(LOG_FILE, true);
            writer = new PrintWriter(fileWriter, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized FileLogger getInstance() {
        if (instance == null) {
            instance = new FileLogger();
        }
        return instance;
    }

    public void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        writer.println(String.format("[%s] %s", timestamp, message));
    }

    public void log(String level, String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        writer.println(String.format("[%s] [%s] %s", timestamp, level, message));
    }

    public void error(String message) {
        log("ERROR", message);
    }
    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}