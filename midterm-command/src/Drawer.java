import javax.swing.*;
import java.awt.event.*;


public class Drawer extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
    private Macro history = new Macro();
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    private JButton button1 = new JButton("button1");
    private JButton button2 = new JButton("button2");

    public Drawer(String title) {
        super(title);
        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(button1);
        buttonBox.add(button2);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            history.clear();
            canvas.repaint();
        }
        if (e.getSource() == button2) {
            history.do2();
            canvas.repaint();
        }
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        Order order = new DrawOrder(canvas, e.getPoint());
        history.append(order);
        order.do1();
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

    public static void main(String[] args) {
        new Drawer("Pattern Sample");
    }
}