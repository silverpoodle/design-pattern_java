import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashedCircle extends JPanel {
    private int centerX, centerY, radius;
    private boolean shouldDrawCircle = false; // 플래그: 원을 그릴지 여부를 결정

    public DashedCircle(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (shouldDrawCircle) { // 플래그가 true일 때만 원을 그림
            Graphics2D g2d = (Graphics2D) g;

            // 점선 스타일로 경계를 설정
            float[] dashPattern = {10, 10}; // 점선 패턴 (길이 10, 공백 10)
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dashPattern, 0));

            // 원 그리기
            g2d.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
        }
    }

    public void setShouldDrawCircle(boolean shouldDrawCircle) {
        this.shouldDrawCircle = shouldDrawCircle;
        repaint(); // 플래그 변경 후 다시 그리기 요청
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle With Button Control");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DashedCircle circlePanel = new DashedCircle(150, 150, 100);

        // 원을 그리는 버튼 추가
        JButton drawButton = new JButton("Draw Circle");

        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                circlePanel.setShouldDrawCircle(true); // 버튼을 누르면 플래그를 true로 설정하고 원을 그림
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(circlePanel, BorderLayout.CENTER);
        frame.add(drawButton, BorderLayout.SOUTH);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}