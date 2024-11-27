import javax.swing.*;

class StrongPlayer extends Player {
    @Override
    public void moveUp(MazeMap map) {
        y = Math.max(y - 1, 0); // 무조건 한 칸 위로 이동
        checkTrap(map);
    }

    @Override
    public void moveDown(MazeMap map) {
        y = Math.min(y + 1, map.getMap().length - 1); // 무조건 한 칸 아래로 이동
        checkTrap(map);
    }

    @Override
    public void moveLeft(MazeMap map) {
        x = Math.max(x - 1, 0); // 무조건 한 칸 왼쪽으로 이동
        checkTrap(map);
    }

    @Override
    public void moveRight(MazeMap map) {
        x = Math.min(x + 1, map.getMap()[0].length - 1); // 무조건 한 칸 오른쪽으로 이동
        checkTrap(map);
    }

    private void checkTrap(MazeMap map) {
        if (map.isTrap(x, y)) {
            JOptionPane.showMessageDialog(null, "StrongPlayer fell into a trap! Restarting...");
            x = 1;
            y = 1;
        }
    }
}


// StrongPlayer 클래스
//class StrongPlayer extends Player {
//    @Override
//    public void moveUp(MazeMap map) {
//        y = Math.max(y - 1, 0); // 무조건 한 칸 위로 이동
//    }
//
//    @Override
//    public void moveDown(MazeMap map) {
//        y = Math.min(y + 1, map.getMap().length - 1); // 무조건 한 칸 아래로 이동
//    }
//
//    @Override
//    public void moveLeft(MazeMap map) {
//        x = Math.max(x - 1, 0); // 무조건 한 칸 왼쪽으로 이동
//    }
//
//    @Override
//    public void moveRight(MazeMap map) {
//        x = Math.min(x + 1, map.getMap()[0].length - 1); // 무조건 한 칸 오른쪽으로 이동
//    }
//}