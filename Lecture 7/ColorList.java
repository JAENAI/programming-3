import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ColorList
{

public static void main(String[] args)
{
   
    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
        public void run()
        {
            final HashMap<String, Color>     M    =    new    HashMap<String, Color>();
            M.put("Black"    ,    new    Color(0,0,0));
            M.put("White"    ,    new    Color(255,255,255));
            M.put("Red"        ,    new    Color(255,0,0));
            M.put("Lime"    ,    new    Color(0,255,0));
            M.put("Blue"    ,    new    Color(0,0,255));
            M.put("Yellow"    ,    new    Color(255,255,0));
            M.put("Cyan"    ,    new    Color(0,255,255));
            M.put("Magenta"    ,    new    Color(255,0,255));
            M.put("Silver"    ,    new    Color(192,192,192));
            M.put("Gray"    ,    new    Color(128,128,128));
            M.put("Maroon"    ,    new    Color(128,0,0));
            M.put("Olive"    ,    new    Color(128,128,0));
            M.put("Green"    ,    new    Color(0,128,0));
            M.put("Purple"    ,    new    Color(128,0,128));
            M.put("Teal"    ,    new    Color(0,128,128));
            M.put("Navy"    ,    new    Color(0,0,128));
            
            JFrame    F    =    new    JFrame();
            F.setTitle("Swing Color List");                         
            F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel    P    =    new    JPanel(new GridLayout(1,2));

            final DefaultListModel<String>    M1    =    new    DefaultListModel<String>();
            
            // ADD THE COLOR NAMES TO THE MODEL
            for(String color:M.keySet()){
                M1.addElement(color);
            }
            
            final JList<String>    L1    =    new    JList<String>(M1);

            // SET SINGLE SELECTION MODE
            L1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            L1.setLayoutOrientation(JList.VERTICAL);

            

            final JPanel        P2    =    new    JPanel();
            
           // ADD LISTENER THAT WILL CHANGE THE BACKGROUND COLOR
           L1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                P2.setBackground(M.get((String)L1.getSelectedValue()));
            }
           });

           JScrollPane LS=new JScrollPane(L1);
            
            P.add(LS);
            P.add(P2);


            
            F.getContentPane().add(P);
            
            F.setSize(400,400); 
            F.setVisible(true); 
        }
    });
}
}
