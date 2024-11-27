import java.awt.*;

// MazeMap 추상 클래스
abstract class MazeMap {
    protected int[][] map;

    public int[][] getMap() {
        return map;
    }

    public abstract int getGoalX();

    public abstract int getGoalY();

    public Point validateMove(int currentX, int currentY, int deltaX, int deltaY) {
        int newX = currentX + deltaX;
        int newY = currentY + deltaY;
        if (newX >= 0 && newX < map[0].length && newY >= 0 && newY < map.length && map[newY][newX] != 1) {
            return new Point(newX, newY);
        }
        return new Point(currentX, currentY);
    }

    public boolean isGoal(int x, int y) {
        return x == getGoalX() && y == getGoalY();
    }

    public boolean isTrap(int x, int y) {
        return false; // 기본적으로 함정 없음
    }

    public MazeMap makeMaze() {return new TrappedMazeMap();}
}