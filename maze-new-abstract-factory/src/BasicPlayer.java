// BasicPlayer 클래스
class BasicPlayer extends Player {
    @Override
    public void moveUp(MazeMap map) {
        move(map, 0, -1);
    }

    @Override
    public void moveDown(MazeMap map) {
        move(map, 0, 1);
    }

    @Override
    public void moveLeft(MazeMap map) {
        move(map, -1, 0);
    }

    @Override
    public void moveRight(MazeMap map) {
        move(map, 1, 0);
    }
}
