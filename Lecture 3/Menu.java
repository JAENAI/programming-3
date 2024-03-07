import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Menu implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e){}
    
    static    JLabel    B    =    new    JLabel();
    
    public static void main(String[] args)
    {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame    F    =    new    JFrame();
                F.setTitle("JMenu Exercise");                         
                F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                F.getContentPane().add(B);
                B.setOpaque(true);
                B.setHorizontalAlignment(JLabel.CENTER);
               
                
                F.setJMenuBar(createJMenuBar());

                F.setSize(400,400);                   // set Window size
                F.setVisible(true); 
            }
        });
    }

    static    JMenuBar    createJMenuBar()
    {
        JMenuBar    M    =    new    JMenuBar();
        
        // Menus
        JMenu C=new JMenu("Color");
        JMenu Name=new JMenu("Name");
        M.add(C);
        M.add(Name);

        // Menu Items for color
        JMenuItem red=new JMenuItem("Red");
        JMenuItem green=new JMenuItem("Green");
        JMenuItem blue=new JMenuItem("Blue");

        C.add(red);
        C.add(green);
        C.add(blue);

        ActionListener getcolor=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource() instanceof JMenuItem)
                {
                    if(((JMenuItem)e.getSource()).getText()=="Red")
                    {
                        B.setBackground(Color.RED);
                    }
                    else if(((JMenuItem)e.getSource()).getText()=="Green")
                    {
                        B.setBackground(Color.GREEN);
                    }
                    else if(((JMenuItem)e.getSource()).getText()=="Blue")
                    {
                        B.setBackground(Color.BLUE);
                    }
                }
            }
        };

        red.addActionListener(getcolor);
        green.addActionListener(getcolor);
        blue.addActionListener(getcolor);

        // Menu Items for name
        JMenuItem alice=new JMenuItem("Alice");
        JMenuItem bob=new JMenuItem("Bob");
        JMenuItem carol=new JMenuItem("Carol");

        Name.add(alice);
        Name.add(bob);
        Name.add(carol);

        ActionListener getname=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource() instanceof JMenuItem)
                {
                    B.setText("Hello "+((JMenuItem)e.getSource()).getText()+"!");
                    B.setFont(new Font("Arial",Font.BOLD,20));
                }
            }

        };

        alice.addActionListener(getname);
        bob.addActionListener(getname);
        carol.addActionListener(getname);


        return M;
    }
       
}
