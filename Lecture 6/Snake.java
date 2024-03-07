import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.BoundedRangeModel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;

class SnakePanel    extends    JPanel    implements    MouseMotionListener,ActionListener
{

    ArrayList<Point>    A    =    new    ArrayList<Point>();
    
    int x;
    int y;

    public    SnakePanel()
    {
        addMouseMotionListener(this);
        setBackground(Color.WHITE);
        
        Timer    timer = new Timer(50, this);
        timer.start(); 
    }

    public    void    paintComponent    (Graphics    G)
    {
        super.paintComponent(G);
        
        Graphics2D    G2    =    (Graphics2D)    G;
        
        // Draw dots
        G2.setColor(new Color(0, 0, 255));
        for(Point point:A)
        {
            G2.fillOval(point.x-2,point.y-2,10,10);
        }

    }


    @Override
    public void mouseDragged(MouseEvent e)
    {

        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

        x    =    e.getX();
        y    =    e.getY();
        A.add(new Point(x, y));
        if(A.size()>50){
            A.remove(0);
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /*A.add(new Point(x, y));
        if(A.size()>50){
            A.remove(0);
        }*/
        
    }
}

public class Snake
{

public static void main(String[] args)
{
    
    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
        public void run()
        {
            JFrame    F    =    new    JFrame();
            F.setTitle("Snake");                         
            F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel    P    =    new    SnakePanel();
            
            F.getContentPane().add(P);
            
            F.setSize(400,400); 
            F.setVisible(true); 
        }
    });
}
}
 


