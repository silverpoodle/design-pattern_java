import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {

    /**
     * java.io.PrintWriter <br/>
     * File(String), OutputStream, Writer 등의 객체를 인수로 받아 더 간편하게 스트림을 연결
     *
     * **/

    private final String LOGFILE = "log.txt";
    private PrintWriter printWriter;
    private static Logger instance = new Logger();

    public Logger() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(LOGFILE);
            printWriter = new PrintWriter(fw, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void log(String message) {
        LocalDateTime dateTime = LocalDateTime.now();
        printWriter.println("message:" + message + ", timestamp: " + dateTime);
    }

    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }
}
