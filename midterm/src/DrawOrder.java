import java.awt.*;

class DrawOrder implements Order {
    protected Drawable drawable;
    private Point position;

    public DrawOrder(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    public void do1() {
        drawable.draw(position.x, position.y);
    }

    public void do2() {
        drawable.undo(position.x, position.y);
    }
}