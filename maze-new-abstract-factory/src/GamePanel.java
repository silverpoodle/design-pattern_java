import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.Instant;

// GamePanel 클래스
class GamePanel extends JPanel {
    private final MazeMap map;
    private final Player player;
    private final int tileSize = 20;
    private final Instant startTime;
    private ColorStrategy colorStrategy;


    public GamePanel(MazeAndPlayerFactory factory) {
        this.map = factory.makeMaze();
        this.player = factory.makePlayer();
        this.colorStrategy = new DefaultColorStrategy();
//        this.map = new TrappedMazeMap();
//        this.player = new BasicPlayer();

        this.startTime = Instant.now(); // 시작 시간 기록
        setPreferredSize(new Dimension(tileSize * map.getMap()[0].length, tileSize * map.getMap().length));
        setBackground(Color.WHITE);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> player.moveUp(map);
                    case KeyEvent.VK_DOWN -> player.moveDown(map);
                    case KeyEvent.VK_LEFT -> player.moveLeft(map);
                    case KeyEvent.VK_RIGHT -> player.moveRight(map);
                }
                if (player.reachedGoal(map)) {
                    long elapsedTime = Duration.between(startTime, Instant.now()).toSeconds();
                    JOptionPane.showMessageDialog(GamePanel.this, "You reached the goal in " + elapsedTime + " seconds!");
                }
                repaint();
            }
        });
        setFocusable(true);
    }

    public void setColorStrategy(ColorStrategy colorStrategy) {
        this.colorStrategy = colorStrategy;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int row = 0; row < map.getMap().length; row++) {
            for (int col = 0; col < map.getMap()[0].length; col++) {
                switch (map.getMap()[row][col]) {
                    case 1 -> { // Wall
                        g.setColor(colorStrategy.getWallColor());
                        g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                    }
                    case 2 -> { // Goal
                        g.setColor(colorStrategy.getGoalColor());
                        g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                    }
                    case 3 -> { // Trap
                        g.setColor(colorStrategy.getTrapColor());
                        g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                    }
                }
            }
        }

        g.setColor(Color.BLUE);
        g.fillOval(player.getX() * tileSize, player.getY() * tileSize, tileSize, tileSize);
    }
}