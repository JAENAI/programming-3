import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

class HangmanPanel extends JPanel   implements KeyListener
{

    char[]  txt     =   "hello world".toCharArray();
    char[]  Z       =   "-----------".toCharArray();
    int     errors  =   0;

    public HangmanPanel()
    {
        setFocusable(true);
        grabFocus();
        addKeyListener(this);
        setBackground(Color.yellow);
    }


    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D  G2  =   (Graphics2D) g;

        G2.drawString(new String(Z),150,350);
        G2.drawLine(100,350,100,100);
        G2.drawLine(100,100,200,100);
        G2.drawLine(200,100,200,120);
        G2.drawString("Errors : "+errors, 20, 20);

        // CHANGE THE FOLLOWING CODE

        if  (errors>0)  
        {
            System.out.println("draw Head");
            G2.drawOval(185,120,30,30);
        }
        if  (errors>1)
        {
            System.out.println("draw Body");
            G2.drawLine(200, 150, 200, 200);
        }
        if  (errors>2)
        {
            System.out.println("draw Arm1");
            G2.drawLine(200,170,170,190);
        }
        if  (errors>3)
        {
            System.out.println("draw Arm2");
            G2.drawLine(200,170,230,190);
        }
        if  (errors>4)
        {
            System.out.println("draw Leg1");
            G2.drawLine(200,200,170,230);
        }
        if  (errors>5) {
            System.out.println("draw Leg2");
            G2.drawLine(200,200,230,230);
            setBackground(Color.red);
            G2.setFont(new Font("Serif", Font.BOLD, 30));
            G2.drawString(new String("GAME OVER"), 20, 20);
        }
        if(String.valueOf(txt).equals(String.valueOf(Z)) && errors<6) 
        {
            setBackground(Color.green);
            G2.setFont(new Font("Serif", Font.BOLD, 30));
            G2.drawString(new String("YOU WON"), 20, 20);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e)
    {
        char c  =   e.getKeyChar();
        System.out.println("key "+c);
        boolean found   =   false;
        for(int i=0 ; i<txt.length ; i++)
        {
            if (c==txt[i])  {Z[i]=c; found=true;}
        }
        if(!found)  errors++;
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}

public class Hangman
{

public static void main(String[] args)
{
    
    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
        public void run()
        {
            JFrame    F    =    new    JFrame();
            F.setTitle("Hangman");                         
            F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel    P    =    new    HangmanPanel();
            
            F.getContentPane().add(P);
            
            F.setSize(400,400); 
            F.setVisible(true); 
        }
    });
}
}
 

