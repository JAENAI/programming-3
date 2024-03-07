import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BoundedRangeModel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class SpeedPanel    extends    JPanel    implements    ChangeListener
{

    BoundedRangeModel    M;

    public    SpeedPanel(BoundedRangeModel    newM)
    {
        M    =    newM;
        setBackground(Color.WHITE);

        // Add ChangeListener
        M.addChangeListener(this);
    }

    public    void    paintComponent    (Graphics    G)
    {
        super.paintComponent(G);
        
        Graphics2D    G2    =    (Graphics2D)    G;
        
        // Draw the demi-circle
        G2.setColor(Color.green);
        G2.fillArc(50,230,200,200,90,90);
        G2.setColor(Color.yellow);
        G2.fillArc(50,230,200,200,30,60);
        G2.setColor(Color.red);
        G2.fillArc(50,230,200,200,0,30);

        //Draw the pointer
        G2.setColor(Color.black);
        G2.fillArc(40,220,220,220,180-M.getValue()-5,5);
    }

    
    @Override
    public void stateChanged(ChangeEvent e)
    {
        repaint();
    }
}

public class Speed
{

public static void main(String[] args)
{
    
    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
        public void run()
        {
            JFrame    F    =    new    JFrame();
            F.setTitle("Speedmeter");                         
            F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JSlider    S    =    new    JSlider(0, 180,100);
            JPanel    P    =    new    SpeedPanel(S.getModel());
            
            F.getContentPane().add(P);
            F.getContentPane().add(S,BorderLayout.SOUTH);
            
            F.setSize(400,400); 
            F.setVisible(true); 
        }
    });
}
}
 