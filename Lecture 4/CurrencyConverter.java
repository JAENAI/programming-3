import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Controller implements ActionListener
{
    JTextField euros;
    JTextField bitcoins;

    public Controller   (JTextField T1,JTextField T2)
    {
        euros      =   T1;
        bitcoins   =   T2;
        euros.addActionListener(this);
        bitcoins.addActionListener(this);
    }

    public void actionPerformed  (ActionEvent e)
    {
        JTextField tmp=(JTextField)e.getSource();
        double val=26436.64;
        if(tmp==euros)
        {
            double b=Double.parseDouble(tmp.getText())/val;
            bitcoins.setText(Double.toString(b));
        }
        else if(tmp==bitcoins)
        {
            double eu=Double.parseDouble(tmp.getText())*val;
            euros.setText(Double.toString(eu));
        }
        // (use e.getSource() to determine the source of the event) 
    }

}

public class CurrencyConverter
{
    public static void main(String[] args)
    {

        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame    F    =    new    JFrame("Converter");
                F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                F.getContentPane().setLayout(new GridLayout(2,1));

                JTextField  t1   =   new JTextField(20);
                JTextField  t2   =   new JTextField(20);

                
                // SET TEXT ALIGNMENT AND BORDER FOR t1
                TitledBorder eur=BorderFactory.createTitledBorder("euros");
                eur.setTitleJustification(TitledBorder.CENTER);
                t1.setBorder(eur);
                t1.setHorizontalAlignment(JTextField.RIGHT);

                // SET TEXT ALIGNMENT AND BORDER FOR t2
                TitledBorder bit=BorderFactory.createTitledBorder("bitcoins");
                bit.setTitleJustification(TitledBorder.CENTER);
                t2.setBorder(bit);
                t2.setHorizontalAlignment(JTextField.RIGHT);
              
                F.getContentPane().add(t1);
                F.getContentPane().add(t2);
                new Controller(t1,t2);
                
                F.pack(); 
                F.setVisible(true); 
            }
        });
    }
}