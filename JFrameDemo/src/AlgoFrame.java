import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoFrame extends JFrame {

    private int canvasWidth;

    private int canvasHeight;

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }

    /**
     * AlgoFrame构造函数
     * @param title 算法名字
     * @param canvasWidth 画布的宽度（注：画布的大小和窗口大小是两个不相关的东西）
     * @param canvasHeight 画布的高度
     * */
    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {

        super(title);   // 窗口对象创建，标题为title

        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;

        AlgoCanvas canvas = new AlgoCanvas();
//        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight)); // 设置画布的长宽
        this.setContentPane(canvas);    // 设置该窗口的画布为canvas

        this.pack();    // pack()方法自动的调整窗口大小为可以容下画布的大小
//        this.setSize(canvasWidth, canvasHeight);    // 默认窗口初始化大小500*500

        this.setResizable(false);   // 用户不能重新定义窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // 窗口关闭后程序运行结束
        this.setVisible(true);  // 启动窗口
    }

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }

    /**
     * 内部画布类，画布大小（JPanel）和窗口大小（JFrame）不是一个东西
     * */
    private class AlgoCanvas extends JPanel {

        /**
         * 绘制图像方法
         * */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g; // 如果绘制2D图像，使用Graphics2D会更好，所以我们默认使用它
            g2d.setColor(Color.RED); // 设置绘制线条的颜色

            // 设置画笔的宽
            int strokeWidth = 10;
            g2d.setStroke(new BasicStroke(strokeWidth));

            Ellipse2D circle = new Ellipse2D.Double(50, 50, 300, 300);
            g2d.draw(circle);

            g2d.setColor(Color.BLUE);
            Ellipse2D circle2 = new Ellipse2D.Double(50, 50, 300, 300);
            g2d.fill(circle2); // 绘制一个实心圆

            // 我们使用Graphics2D而不使用Graphics
//            // 绘制一个圆或者椭圆（取决于i2, i3是正方形还是长方形）
//            // i, i1是屏幕坐标系的(x, y)而不是数学坐标系的
//            g.drawOval(50, 50, 300, 300);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
