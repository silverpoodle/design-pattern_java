import java.awt.*;

public class DefaultColorStrategy implements ColorStrategy{
    @Override
    public Color getWallColor() {
        return Color.BLACK;
    }

    @Override
    public Color getTrapColor() {
        return Color.RED;
    }

    @Override
    public Color getGoalColor() {
        return Color.ORANGE;
    }
}
