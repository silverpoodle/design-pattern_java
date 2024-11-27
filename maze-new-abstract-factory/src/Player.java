import javax.swing.*;
import java.awt.*;

// Player 추상 클래스
abstract class Player {
    protected int x = 1, y = 1;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(MazeMap map, int deltaX, int deltaY) {
        Point newPosition = map.validateMove(x, y, deltaX, deltaY);
        x = newPosition.x;
        y = newPosition.y;
        if (map.isTrap(x, y)) {
            handleTrap();
        }
    }

    public boolean reachedGoal(MazeMap map) {
        return map.isGoal(x, y);
    }

    public abstract void moveUp(MazeMap map);

    public abstract void moveDown(MazeMap map);

    public abstract void moveLeft(MazeMap map);

    public abstract void moveRight(MazeMap map);

    protected void handleTrap() {
        JOptionPane.showMessageDialog(null, "You fell into a trap! Restarting...");
        x = 1;
        y = 1;
    }

    public Player makePlayer() {return  new BasicPlayer();}
}