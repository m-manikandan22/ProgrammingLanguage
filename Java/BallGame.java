import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BallGame extends Frame implements MouseMotionListener {
    int circleX =200 , circleY = 200,circleRadius=20;
    BallGame()
    {
        addMouseMotionListener(this);
        setSize(400,400);
        setLayout(null);
        setTitle("Ball Game");
        setVisible(true);
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillOval(circleX,circleY,2*circleRadius,2*circleRadius);
    }
    public void mouseDragged(MouseEvent e){

    }

    public void mouseMoved(MouseEvent e){
        int x = e.getX();
        int y = e.getY();

        if(x < circleX + circleRadius)
            circleX++;
        if(x> circleX+circleRadius)
            circleX--;
        if(y< circleY+circleRadius)
            circleY++;
        if(y> circleX + circleRadius)
            circleY--;
        repaint();
    }

    static void main(String[] args) {
        new BallGame();
    }
}

