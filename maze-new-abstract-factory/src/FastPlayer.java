// FastPlayer 클래스
class FastPlayer extends Player {
    @Override
    public void moveUp(MazeMap map) {
        if (map.validateMove(x, y, 0, -2).y == y - 2) move(map, 0, -2);
        else move(map, 0, -1);
    }

    @Override
    public void moveDown(MazeMap map) {
        if (map.validateMove(x, y, 0, 2).y == y + 2) move(map, 0, 2);
        else move(map, 0, 1);
    }

    @Override
    public void moveLeft(MazeMap map) {
        if (map.validateMove(x, y, -2, 0).x == x - 2) move(map, -2, 0);
        else move(map, -1, 0);
    }

    @Override
    public void moveRight(MazeMap map) {
        if (map.validateMove(x, y, 2, 0).x == x + 2) move(map, 2, 0);
        else move(map, 1, 0);
    }
}