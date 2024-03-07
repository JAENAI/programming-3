import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JTextArea;

class ExitAction extends AbstractAction
{
    public    ExitAction()
    {
        super("Exit");
    }

    public void actionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
}
 

class ClearAction extends AbstractAction
{
    JTextArea    T;

    public    ClearAction(JTextArea A)
    {
        super("Clear");
        T=A;
    }

    public void actionPerformed(ActionEvent e)
    {
        T.setText("");
    }
}

class ColorAction extends AbstractAction
{
    JTextArea    T;
    Color        CC;

    public    ColorAction(JTextArea A, Color C, String Name)
    {
        super(Name);
        
        T=A;
        CC=C;
    }

    public void actionPerformed(ActionEvent e)
    {
        T.setBackground(CC);
    }
}


public class TextEditor 
{
    public static void main(String[] args)
    {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame    F    =    new    JFrame();
                F.setTitle("TextEditor");                     
                F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JTextArea A=new JTextArea();

                JMenuBar    M    =    new    JMenuBar();

                //Colors
                Color re=new Color(255,0,0);
                Color gr=new Color(0,255,0);
                Color bl=new Color(0,0,255);


                // Menus
                JMenu File=new JMenu("File");
                JMenu Color=new JMenu("Color");
                M.add(File);
                M.add(Color);

                // Menu Items for color
                JMenuItem red=new JMenuItem("Red");
                JMenuItem green=new JMenuItem("Green");
                JMenuItem blue=new JMenuItem("Blue");

                Color.add(red);
                Color.add(green);
                Color.add(blue);
                
                red.setAction(new ColorAction(A, re, "Red"));
                blue.setAction(new ColorAction(A, bl, "Blue"));
                green.setAction(new ColorAction(A,gr,"Green"));

                // Menu Items for File
                JMenuItem clear=new JMenuItem("Clear");
                JMenuItem exit=new JMenuItem("Exit");

                File.add(clear);
                File.add(exit);

                clear.setAction(new ClearAction(A));
                exit.setAction(new ExitAction());

                // ToolBar Menu
                JToolBar B=new JToolBar();

                // ToolBar buttons
                JButton r=new JButton("RED");
                JButton b=new JButton("BLUE");
                JButton g=new JButton("GREEN");

                B.add(r);
                B.add(b);
                B.add(g);

                r.setAction(new ColorAction(A,re,"Red"));
                b.setAction(new ColorAction(A, bl, "Blue"));
                g.setAction(new ColorAction(A, gr, "Green"));
                
                F.setJMenuBar(M);
                F.add(A);
                F.add(B,BorderLayout.SOUTH);

                F.setSize(400,400);                   // set Window size
                F.setVisible(true); 
            }
        });
    }
    
}


