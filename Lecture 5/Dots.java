import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

class DotsPanel    extends    JPanel     implements    MouseListener
{

    public    ArrayList<Point>    L    =    new    ArrayList<Point>();

    public    DotsPanel()
    {
        setBackground(Color.WHITE);
        addMouseListener(this);
    }

    // ADD CODE TO DRAW THE DOTS
    public void paintComponent(Graphics G)
    {
        super.paintComponent(G);
        G.setColor(new Color(0, 0, 0));
        for(Point point:L)
        {
            G.fillOval(point.x-2,point.y-2,10,10);
        }
    }
    
    // ADD CLEAR METHOD
    public void Clear()
    {
        L.clear();
        this.repaint();
    }

    // ADD MOUSE LISTENERS
    @Override
    public void mouseClicked(MouseEvent e)
    {
        Point b=e.getPoint();
        L.add(b);
        this.repaint();
    }
    @Override
    public void mouseExited(MouseEvent e){}
    @Override
    public void mouseEntered(MouseEvent e){}
    @Override 
    public void mouseReleased(MouseEvent e){}
    @Override
    public void mousePressed(MouseEvent e){}

    
}

public class Dots
{

public static void main(String[] args)
{
    
    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
        public void run()
        {
            JFrame    F    =    new    JFrame();
            F.setTitle("Swing Painting");                         
            F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            final DotsPanel    P    =    new    DotsPanel();
            
            JButton        B    =    new    JButton("Clear");
            
            // ADD ACTIONLISTENER TO BUTTON
            B.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    P.Clear();
                }
            });
            
            F.getContentPane().add(P);
            F.getContentPane().add(B,BorderLayout.SOUTH);
            
            F.setSize(400,400); 
            F.setVisible(true); 
        }
    });
}
}
 


