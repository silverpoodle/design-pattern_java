public abstract class MazeAndPlayerFactory {
    public MazeMap makeMaze() {return new TrappedMazeMap();}
    public Player makePlayer() {return new BasicPlayer();}
}
