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


    public GamePanel(MazeAndPlayerFactory factory, ColorStrategy colorStrategy) {
        this.map = factory.makeMaze();
        this.player = factory.makePlayer();
//        this.map = new TrappedMazeMap();
//        this.player = new BasicPlayer();
        this.colorStrategy = colorStrategy;

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


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        colorStrategy.render(g,map,tileSize,player);

    }
}