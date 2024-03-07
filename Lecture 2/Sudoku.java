import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.*;

public class Sudoku 
{
     public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame  F = new JFrame("Sudoku");
                F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                F.setSize(500, 500);
                F.setVisible(true);
                F.getContentPane().setLayout(new BorderLayout());

                /*JTextField  T   =   new JTextField();
                F.getContentPane().add(T,BorderLayout.NORTH);*/

                JPanel  P = new JPanel();
                P.setBackground(Color.GREEN);
                P.setLayout(new GridLayout(9,9));
                F.getContentPane().add(P);

                JTextField T[]= new JTextField[81];

                for(int i=0;i<81;i++)
                {
                    T[i]=new JTextField();
                    P.add(T[i]);

                }


            } });
    }
}
