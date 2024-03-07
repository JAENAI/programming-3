import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RgbSlider
{
    // Declare P1 as a static variable so it can be accessed by updateBackgroundColor
    private static JPanel P1;

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
                //JPanel    P1    =    new JPanel(); --> already outside main
                //default background color
                P1 = new JPanel();
                //standard Background Color
                P1.setBackground(Color.BLACK);

                JPanel    P2    =    new JPanel();
                P2.setLayout(new GridLayout(3,1));

                // add titles for sliders
                TitledBorder title1 = BorderFactory.createTitledBorder("red");
                TitledBorder title2 = BorderFactory.createTitledBorder("green");
                TitledBorder title3 = BorderFactory.createTitledBorder("blue");

                //Array for Sliders with
                JSlider[] sliders = new JSlider[3];

                //Turn on labels at major tick marks.
                final int distance = 50;

                //loop for generating the sliders
                for (int i = 0; i < sliders.length ; i++){
                    sliders[i] = new JSlider(0,255,0);
                    sliders[i].setMajorTickSpacing(distance);
                    sliders[i].setMinorTickSpacing(distance);
                    sliders[i].setPaintTicks(true);
                    sliders[i].setPaintLabels(true);

                    //set the border title based on the index
                    if (i == 0) {
                        sliders[i].setBorder(title1);
                    } else if (i == 1) {
                        sliders[i].setBorder(title2);
                    } else {
                        sliders[i].setBorder(title3);
                    }
                    P2.add(sliders[i]);

                    // Action Listener
                    sliders[i].addChangeListener(new ChangeListener() {
                        @Override
                        public void stateChanged(ChangeEvent e) {
                            JSlider source = (JSlider)e.getSource();
                            int red = sliders[0].getValue();
                            int green = sliders[1].getValue();
                            int blue = sliders[2].getValue();
                            updateBackgroundColor(red, green, blue);
                        }
                    });
            }
                F.getContentPane().add(P1);
                F.getContentPane().add(P2,BorderLayout.SOUTH);

                F.setSize(400,400);
                F.setVisible(true);
            }
        });
    }
    // Method to update the background color based on slider values
    static void updateBackgroundColor(int red, int green, int blue) {
        // Create a new Color
        Color newColor = new Color(red, green, blue);
        P1.setBackground(newColor);
}

}