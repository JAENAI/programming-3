import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;  

public class ClickCounter implements MouseListener
{
    static int i=0;

    @Override
    public void mouseExited(MouseEvent e){

    }
    @Override
    public void mouseEntered(MouseEvent e){

    }
    @Override 
    public void mouseReleased(MouseEvent e){

    }
    @Override
    public void mousePressed(MouseEvent e){

    }
    @Override
    public void mouseClicked(MouseEvent e){

    }
    private static void initGUI() 
    {
        JFrame frame = new JFrame("Click Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Click Count :"+i);
        frame.getContentPane().add(label);
        label.setHorizontalAlignment(JLabel.CENTER);

        JButton button =new JButton( "Click Here", null);
        button.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                i++;
                label.setText("Click Count :"+i);
            }
            @Override
            public void mouseExited(MouseEvent e){

            }
            @Override
            public void mouseEntered(MouseEvent e){

            }
            @Override 
            public void mouseReleased(MouseEvent e){

            }
            @Override
            public void mousePressed(MouseEvent e){

            }
        });
        frame.getContentPane().add(button,BorderLayout.SOUTH);

        frame.pack();
        frame.setSize(400,400);
        frame.setVisible(true);
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