import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumPad extends JFrame implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame  F = new JFrame("NumPad");
                F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                F.setSize(400, 300);
                F.setVisible(true);
                F.getContentPane().setLayout(new BorderLayout());

                JTextField  T   =   new JTextField();
                F.getContentPane().add(T,BorderLayout.NORTH);

                JPanel  P = new JPanel();
                F.getContentPane().add(P,BorderLayout.CENTER);

                P.setBackground(Color.GREEN);
                P.setLayout(new GridLayout(4, 3));


                JButton[] buttons=new JButton[12];
                int i=0;
                while(i<12){
                    if(i==9)
                    {
                        buttons[i]=new JButton(".");
                    }
                    else if(i==10)
                    {
                        buttons[i]=new JButton("0");
                    }
                    else if(i==11)
                    {
                        buttons[i]=new JButton("DEL");
                    }
                    else
                    {
                        buttons[i]=new JButton(Integer.toString(i+1));
                    }
                    P.add(buttons[i]);
                    i++;
                }

                ActionListener write=new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        if(e.getSource() instanceof JButton)
                        {
                            String current=T.getText();
                            if(((JButton)e.getSource()).getText()=="DEL")
                            {
                                if(current.length()!=0)
                                {
                                    current=current.substring(0, current.length()-1);
                                    T.setText(current);
                                }
                                
                            }
                            else
                            {
                                T.setText(current+((JButton)e.getSource()).getText());
                            }
                        }
                    }
                };
                    
                for(int j=0;j<12;j++)
                {
                    buttons[j].addActionListener(write);
                }

                // STEP 1: create 12 buttons

                // STEP 2: set layout of panel

                // STEP 3: add buttons to panel

                // STEP 4: add listeners

            } });
    }
}