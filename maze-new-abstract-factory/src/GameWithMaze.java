import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;

// GameWithMaze 클래스
public class GameWithMaze extends JFrame {
    public GameWithMaze() {
        setTitle("Maze Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new GamePanel(new MazeAndPlayerFactory() {
        }, new DefaultColorStrategy()));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameWithMaze());
    }
}

