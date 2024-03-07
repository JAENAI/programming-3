import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyButton extends JButton implements ActionListener
{
    public MyButton()
    {
        setText("*");
        addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(getText()=="*")
        {
            setText("");
        }
        else if(getText()=="")
        {
            setText("*");
        }
    }
}

public class Toggle 
{
    public static void main(String[] args)
    {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame    F    =    new    JFrame();
                F.setTitle("Toggle Grid Exercise");                         
                F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                F.getContentPane().setBackground(Color.GREEN);
                F.getContentPane().setLayout(new GridLayout(4,4));

                for (int i=0 ; i<16 ; i++)
                {
                     F.getContentPane().add(new MyButton());
                }
                
                F.setSize(400,400); 
                F.setVisible(true); 
            }
        });
    }
}
