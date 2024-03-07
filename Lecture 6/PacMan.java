import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BoundedRangeModel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;

class PacManPanel    extends    JPanel    implements    MouseMotionListener,ActionListener
{

    int x=200;
    int y=200;
    int angle=350;
    
    int t    =    30;

    public    PacManPanel()
    {
        addMouseMotionListener(this);
        setBackground(Color.CYAN);
        
        Timer    timer = new Timer(50, this);
        timer.start(); 
    }

    public    void    paintComponent    (Graphics    G)
    {
        super.paintComponent(G);
        
        Graphics2D    G2    =    (Graphics2D)    G;
        
        // Draw PacMan
        G2.setColor(Color.yellow);
        G2.fillArc(x,y,100,100,0,angle);
    }


    // ADD CODE HERE (FOR 2 LISTENERS)
    @Override
    public void mouseMoved(MouseEvent e)
    {}
    @Override
    public void mouseDragged(MouseEvent e)
    {
        x=(int)(e.getPoint().getX());
        y=(int)(e.getPoint().getY());
        angle=360;
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        angle=340;
        repaint();
    }
}

public class PacMan
{

public static void main(String[] args)
{
    
    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
        public void run()
        {
            JFrame    F    =    new    JFrame();
            F.setTitle("PacMan");                         
            F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel    P    =    new    PacManPanel();
            
            F.getContentPane().add(P);
            
            F.setSize(400,400); 
            F.setVisible(true); 
        }
    });
}
}
 



