import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 * Factory Pattern
 * 1. Simple Factory Method
 * 2. GoF Factory Method
 * 3. Abstract Factory Pattern
 */

// a1-a2 비밀번호, a3 폭탄, a5-a6 비밀번호
public class MazeCreator {
    public  Maze createMaze() {
        Maze maze = makeMaze();

        Room room1 = makeRoom(1);
        Room room2 = makeRoom(2);
        Room room3 = makeRoom(3);
        Room room4 = makeRoom(4);
        Room room5 = makeRoom(5);
        Room room6 = makeRoom(6);

        Door door1 = makeDoor(room1, room2);
        Door door2 = makeDoor(room1, room4);
        Door door3 = makeDoor(room2, room3);
        Door door4 = makeDoor(room3, room4);
        Door door5 = makeDoor(room4, room5);
        Door door6 = makeDoor(room5, room6);

        room1.setSide(Direction.NORTH, door1);
        room1.setSide(Direction.EAST, door2);
        room1.setSide(Direction.SOUTH, new Wall());
        room1.setSide(Direction.WEST, new Wall());

        room2.setSide(Direction.NORTH, new Wall());
        room2.setSide(Direction.EAST, door3);
        room2.setSide(Direction.SOUTH, door1);
        room2.setSide(Direction.WEST, new Wall());

        room3.setSide(Direction.NORTH, new Wall());
        room3.setSide(Direction.EAST, new Wall());
        room3.setSide(Direction.SOUTH, door4);
        room3.setSide(Direction.WEST,door3);

        room4.setSide(Direction.NORTH, door4);
        room4.setSide(Direction.EAST, door5);
        room4.setSide(Direction.SOUTH, new Wall());
        room4.setSide(Direction.WEST, door2);

        room5.setSide(Direction.NORTH, new Wall());
        room5.setSide(Direction.EAST, new Wall());
        room5.setSide(Direction.SOUTH, door6);
        room5.setSide(Direction.WEST, door5);

        room6.setSide(Direction.NORTH, door6);
        room6.setSide(Direction.EAST, new Wall());
        room6.setSide(Direction.SOUTH, new Wall());
        room6.setSide(Direction.WEST, new Wall());


        maze.addRoom(room1);
        maze.addRoom(room2);
        maze.addRoom(room3);
        maze.addRoom(room4);
        maze.addRoom(room5);
        maze.addRoom(room6);

        maze.setCurrentRoom(1);

        return maze;
    }

    public Maze makeMaze() {
        return new Maze();
    }

    public Wall makeWall() {
        return new Wall();
    }

    public Room makeRoom(int i) {
        return new Room(i);
    }
    public Door makeDoor(Room room1, Room room2) {
        return new Door(room1, room2);
    }


    public static void main(String[] args) {
        MazeCreator mazeCreator = new MyMazeCreator();
        Maze maze = mazeCreator.createMaze();
        MazeController controller = MazeController.getInstance();
        controller.setMaze(maze);
        controller.setVisible(true);
        controller.setSize(new Dimension(300, 200));
        controller.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
