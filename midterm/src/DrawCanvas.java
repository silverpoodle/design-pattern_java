import java.awt.*;

class DrawCanvas extends Canvas implements Drawable {
    private Color color = Color.red;
    private int radius = 6;
    private Macro history;

    public DrawCanvas(int width, int height, Macro history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    public void paint(Graphics g) {
        history.do1();
    }


    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }


    public void undo(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(getBackground());
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}