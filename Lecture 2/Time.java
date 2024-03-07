import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.lang.Thread;

public class Time
{
    private static void initGUI() 
    {
        JFrame frame = new JFrame("Time");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("The time is");
        frame.getContentPane().add(label);
        label.setHorizontalAlignment(JLabel.CENTER);

        frame.pack();
        frame.setSize(400,400);
        frame.setVisible(true);
        
        Runnable setTime=new Runnable()
        {
            public void run()
            {
                label.setText("The time is "+java.time.LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
            }
        };
        
        ScheduledExecutorService ex=Executors.newScheduledThreadPool(1);
        ex.scheduleAtFixedRate(setTime, 0, 1,TimeUnit.SECONDS);

    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run()
            {
                initGUI();
            }
        });
    }
}
