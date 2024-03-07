import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Graphics;

class MyPanel    extends    JPanel
{

    public    MyPanel()
    {
        setBackground(Color.WHITE);
    }

    public    void    paintComponent    (Graphics    G)
    {
        // Draw Squares
        G.setColor(Color.RED);
        G.drawRect(100,100, 100,100);
        G.fillRect(100,100, 100,100);

        G.setColor(Color.GREEN);
        G.drawRect(100,200,100,100);
        G.fillRect(100,200,100,100);

        G.setColor(Color.BLACK);
        G.drawRect(200,200,100,100);
        
        G.setColor(Color.BLUE);
        G.drawRect(200,100,100,100);
        G.fillRect(200,100,100,100);

        //Draw Lines

        G.setColor(Color.BLACK);

        for(int i=0;i<400;i+=20)
        {
            G.drawLine(0,i,400-i,0);
            G.drawLine(400,400-i,i,400);
        }

        System.out.println("paint(.)");
    }
}

public class CustomPaint
{
    public static void main(String[] args)
    {
    
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame    F    =    new    JFrame();
                F.setTitle("Swing custom paint");                         
                F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
                JPanel    P    =    new    MyPanel();
            
                F.getContentPane().add(P);
            
                F.setSize(400,400); 
                F.setVisible(true); 
            }
        });
    }   
}
