import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;


class ClockPanel extends JPanel
{

    public ClockPanel()
    {
        setBackground(Color.WHITE);
        Timer t=new Timer(1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                repaint();
            }
            
        });
        t.start();
    }

    public void paintComponent(Graphics G)
    {
        //Get current time
        LocalTime tmp=java.time.LocalTime.now();
        int h=tmp.getHour();
        int m=tmp.getMinute();
        int s=tmp.getSecond();

        // Draw clock face
        G.setColor(Color.WHITE);
        G.fillOval(getWidth()/2-150,getHeight()/2-150,300, 300);
        G.setColor(Color.BLACK);
        G.drawOval(getWidth()/2-150,getHeight()/2-150,300, 300);

        //Draw numbers
        G.setColor(Color.BLACK);
        //G.setFont(new Font("SansSerif",Font.BOLD,20));
        for(int i=1;i<=12;i++)
        {
            G.drawString(Integer.toString(i),(int)(getWidth()/2-135*Math.sin(Math.toRadians(360-(i*30)))),(int)(getHeight()/2-135*Math.cos(Math.toRadians(360-(i*30)))));
        }

        // Draw hour hand
        G.drawLine(getWidth()/2,getHeight()/2,(int)(getWidth()/2+75*Math.sin(Math.toRadians(30*h+0.5*m))),(int)(getHeight()/2-75*Math.cos(Math.toRadians(30*h+0.5*m))));

        // Draw minute hand
        G.drawLine(getWidth()/2,getHeight()/2,(int)(getWidth()/2+120*Math.sin(Math.toRadians(6*m+0.1*s))),(int)(getHeight()/2-120*Math.cos(Math.toRadians(6*m+0.1*s))));

        //Draw second hand
        G.setColor(Color.RED);
        G.drawLine(getWidth()/2,getHeight()/2,(int)(getWidth()/2+120*Math.sin(Math.toRadians(6*s))),(int)(getHeight()/2-120*Math.cos(Math.toRadians(6*s))));

    }
}

public class Clock 
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

                ClockPanel P=new ClockPanel();
                F.getContentPane().add(P);

                F.setSize(400,400); 
                F.setVisible(true); 
            }

        });
    }
}
