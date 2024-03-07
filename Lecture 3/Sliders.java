import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Sliders implements ChangeListener
{
     @Override
    public void stateChanged(ChangeEvent e){}
    
    public static void main(String[] args)
    {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame    F    =    new    JFrame();
                F.setTitle("Color Sliders Exercise");                         
                F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // ADD TOP PANEL
                F.setLayout(new GridLayout(2,1));

                JPanel    P1    =    new JPanel();
                
                JPanel    P2    =    new JPanel();
                P2.setLayout(new GridLayout(3,1));
                Border sliders=BorderFactory.createEmptyBorder();
                P2.setBorder(sliders);
                
                JSlider s1    = new JSlider(0,255,0);
                JSlider s2    = new JSlider(0,255,0);
                JSlider s3    = new JSlider(0,255,0);

                // add code for look of sliders
                // add titles for sliders

                s1.setMajorTickSpacing(50);
                s2.setMajorTickSpacing(50);
                s3.setMajorTickSpacing(50);

                s1.setPaintTicks(true);
                s2.setPaintTicks(true);
                s3.setPaintTicks(true);


                s1.setPaintLabels(true);
                s2.setPaintLabels(true);
                s3.setPaintLabels(true);



                TitledBorder t1=BorderFactory.createTitledBorder("red");
                s1.setBorder(t1);
                TitledBorder t2=BorderFactory.createTitledBorder("green");
                s2.setBorder(t2);
                TitledBorder t3=BorderFactory.createTitledBorder("blue");
                s3.setBorder(t3);
                
                P2.add(s1);
                P2.add(s2);
                P2.add(s3);

                
                ChangeListener    L    =    new    ChangeListener() {

                    int r=0;
                    int g=0;
                    int b=0;

                    
                   // ADD LISTENER IMPLEMENTATION
                   @Override
                   public void stateChanged(ChangeEvent e)
                   {
                    
                    JSlider tmp=(JSlider)e.getSource();
                    if(tmp==s1)
                    {
                        r=tmp.getValue();
                    }
                    else if(tmp==s2)
                    {
                        g=tmp.getValue();
                    }
                    else if(tmp==s3)
                    {
                        b=tmp.getValue();
                    }
                    P1.setBackground(new Color(r,g,b));
                   }

                };
                
                s1.addChangeListener(L);
                s2.addChangeListener(L);
                s3.addChangeListener(L);

                

                
                F.getContentPane().add(P1);
                F.getContentPane().add(P2);
                
                F.setSize(400,400);
                F.setVisible(true); 
            }
        });
    }

}


