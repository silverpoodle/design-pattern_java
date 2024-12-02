import java.awt.*;

abstract class ColorStrategy {
//    abstract Color getWallColor();
//    abstract Color getTrapColor();
//    abstract Color getGoalColor();

    abstract void render(Graphics g, MazeMap m, int tileSize, Player p);
}
