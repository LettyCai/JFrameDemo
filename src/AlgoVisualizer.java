import java.awt.*;
import java.awt.event.*;

public class AlgoVisualizer {
    private Circle[] circles;
    private AlgoFrame frame;
    private boolean isAnimated = true;

    public AlgoVisualizer(int sceneWidth,int sceneHeight,int N){
        int R = 50;
        circles = new Circle[N];
        for(int i=0;i<N;i++){
            int x = (int)Math.random()*(sceneWidth-2*R)+R;
            int y = (int)Math.random()*(sceneHeight-2*R)+R;
            int vx = (int)(Math.random()*11-5);
            int vy = (int)(Math.random()*11-5);
            circles[i] = new Circle(x,y,R,vx,vy);

        }

        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("welcome", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListner());
            new Thread(() -> {
                run();

            }).start();
        });
    }

    private void run(){
        while (true) {

            frame.render(circles);
            AlgoVisHelper.pause(20);

            if(isAnimated)
            for (Circle circle : circles)
                circle.move(0,0,frame.getCanvasWidth(),frame.getCanvasHeight());

        }
    }

    private class AlgoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent event){
            if(event.getKeyChar() == ' ')
                isAnimated=!isAnimated;

        }

    }

    private class AlgoMouseListner extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent event) {
            event.translatePoint(0,-(frame.getBounds().height-frame.getCanvasHeight()));
            //System.out.println(event.getPoint());
            for(Circle circle:circles)
                if(circle.contain(event.getPoint())){
                    circle.isFilled = !circle.isFilled;
                }
                ;
        }
    }
}
