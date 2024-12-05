// AdvancedMazeMap 클래스 - 14x10 크기의 복잡한 미로를 제공
class AdvancedMazeMap extends MazeMap {
    public AdvancedMazeMap() {
        this.map = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1}
        };
    }

    @Override
    public int getGoalX() {
        return 12;
    }

    @Override
    public int getGoalY() {
        return 9;
    }
}