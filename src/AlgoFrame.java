import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoFrame extends JFrame {

    private int canvasWidth,canvasHeight;

    public AlgoFrame(String title,int canvasWidth,int canvasHeight){
        super(title);

        this.canvasWidth=canvasWidth;
        this.canvasHeight=canvasHeight;

        AlgoCanvas canvas= new AlgoCanvas();

        this.setContentPane(canvas);
        pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setVisible(true);
    }

    public AlgoFrame(String title){
        this(title,1024,768);
    }

    public int getCanvasWidth(){return this.canvasWidth;}
    public int getCanvasHeight(){return this.canvasHeight;}

    private class AlgoCanvas extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            Ellipse2D circle = new Ellipse2D.Double(50,50,300,300);

            int strokeWidth = 10;
            g2d.setStroke(new BasicStroke(strokeWidth));

            g2d.setColor(Color.red);
            g2d.draw(circle);


            g2d.setColor(Color.red);
            Ellipse2D circle2 =new Ellipse2D.Double(60,60,280,280);
            g2d.fill(circle2);
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
}
