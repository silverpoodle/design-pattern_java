// TrappedMazeMap 클래스
class TrappedMazeMap extends MazeMap {
    public TrappedMazeMap() {
        this.map = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1, 0, 3, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 1, 3, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 3, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 2, 1}
        };
    }

    @Override
    public int getGoalX() {
        return 8;
    }

    @Override
    public int getGoalY() {
        return 8;
    }

    @Override
    public boolean isTrap(int x, int y) {
        return map[y][x] == 3;
    }
}