import java.awt.*;

public class DefaultColorStrategy extends ColorStrategy{
//    @Override
//    public Color getWallColor() {
//        return Color.BLACK;
//    }
//
//    @Override
//    public Color getTrapColor() {
//        return Color.RED;
//    }
//
//    @Override
//    public Color getGoalColor() {
//        return Color.ORANGE;
//    }

    @Override
    void render(Graphics g, MazeMap map, int tileSize, Player player) {
        for (int row = 0; row < map.getMap().length; row++) {
            for (int col = 0; col < map.getMap()[0].length; col++) {
                switch (map.getMap()[row][col]) {
                    case 1 -> {
                        g.setColor(Color.BLACK);
                        g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                    }
                    case 2 -> {
                        g.setColor(Color.RED);
                        g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                    }
                    case 3 -> {
                        g.setColor(Color.GREEN);
                        g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                    }
                }
            }
        }

        g.setColor(Color.BLUE);
        g.fillOval(player.getX() * tileSize, player.getY() * tileSize, tileSize, tileSize);
    }


}
