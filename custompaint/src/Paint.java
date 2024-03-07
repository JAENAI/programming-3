import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint
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

                JPanel    P    =    new    JPanel()
                {
                    public    void    paintComponent    (Graphics    G)
                    {
                        super.paintComponent(G);
                        G.setColor(Color.BLACK);
                        G.fillRect(100, 100, 200, 200);

                        // Added Code

                        //First figure
                        G.setColor(Color.GREEN);
                        G.fillRect(100,100,100,100);
                        G.setColor(Color.BLACK);
                        G.fillRect(125,125,50,50);

                        //Second figure
                        for(int i=1;i<10;i++){
                            G.setColor(Color.WHITE);
                            G.drawLine(200+i*10,100,200+i*10,200);
                        }

                        // Third figure
                        G.setColor(Color.YELLOW);
                        G.fillOval(100,200,100,100);
                        G.setColor(Color.BLACK);
                        G.fillOval(125,225,50,50);

                        //Fourth figure

                        G.setColor(Color.BLUE);
                        G.fillArc(200,200,100,100,0,270);
                        G.setColor(Color.RED);
                        G.fillArc(200,200,100,100,270,90);


                    }
                };

                F.getContentPane().add(P);
                F.setSize(400,400);
                F.setVisible(true);
            }
        });
    }
}