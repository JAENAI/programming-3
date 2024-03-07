import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class ListExchange
{

public static void main(String[] args)
{
    
    final    String[] Countries    =    new String[]{"Afghanistan","Albania","Algeria","Andorra","Angola","Antigua & Deps","Argentina","Armenia",
            "Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize",
            "Benin","Bhutan","Bolivia","Bosnia Herzegovina","Botswana","Brazil","Brunei","Bulgaria","Burkina","Burundi",
            "Cambodia","Cameroon","Canada","Cape Verde","Central African Rep","Chad","Chile","China","Colombia","Comoros",
            "Congo","Congo {Democratic Rep}","Costa Rica","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti",
            "Dominica","Dominican Republic","East Timor","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea",
            "Estonia","Ethiopia","Fiji","Finland","France","Gabon","Gambia","Georgia","Germany","Ghana","Greece","Grenada",
            "Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Honduras","Hungary","Iceland","India","Indonesia","Iran",
            "Iraq","Ireland","Israel","Italy","Ivory Coast","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Kiribati",
            "Korea North","Korea South","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya",
            "Liechtenstein","Lithuania","Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta",
            "Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro",
            "Morocco","Mozambique","Myanmar","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Niger",
            "Nigeria","Norway","Oman","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland",
            "Portugal","Qatar","Romania","Russian Federation","Rwanda","St Kitts & Nevis","St Lucia",
            "Saint Vincent & the Grenadines","Samoa","San Marino","Sao Tome & Principe","Saudi Arabia","Senegal","Serbia",
            "Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa",
            "South Sudan","Spain","Sri Lanka","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan",
            "Tajikistan","Tanzania","Thailand","Togo","Tonga","Trinidad & Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu",
            "Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","Uruguay","Uzbekistan","Vanuatu",
            "Vatican City","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe"};
    
    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
        public void run()
        {
            JFrame    F    =    new    JFrame();
            F.setTitle("List Exchange");                         
            F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel    P    =    new    JPanel(new GridLayout(1,3));

            final DefaultListModel<String>    M1    =    new    DefaultListModel<String>();
            final DefaultListModel<String>    M2    =    new    DefaultListModel<String>();
            final JList    L1    =    new    JList(M1);
            final JList    L2    =    new    JList(M2);  

            L1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            L1.setLayoutOrientation(JList.VERTICAL);
            L2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            L2.setLayoutOrientation(JList.VERTICAL);

            for (String S : Countries)
            {
                M1.addElement(S);
            }

            JButton    B1    =    new    JButton    (">>>");
            JButton    B2    =    new    JButton    ("<<<");
            JButton    B3    =    new    JButton    ("ALL >>>");
            JButton    B4    =    new    JButton    ("<<< ALL");
            
            JPanel    ButtonPanel    =    new    JPanel();
            
            // ADD BUTTONS TO BUTTONPANEL USING A BOXLAYOUT 
            ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.Y_AXIS));

            
            B1.setAlignmentX(Component.CENTER_ALIGNMENT);
            B2.setAlignmentX(Component.CENTER_ALIGNMENT);
            B3.setAlignmentX(Component.CENTER_ALIGNMENT);
            B4.setAlignmentX(Component.CENTER_ALIGNMENT);

            ButtonPanel.add(Box.createVerticalGlue());
            ButtonPanel.add(B1);
            ButtonPanel.add(B2);
            ButtonPanel.add(B3);
            ButtonPanel.add(B4);
            ButtonPanel.add(Box.createVerticalGlue());


            // ADD LISTENERS FOR THE BUTTONS
            B1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    Object[] values=L1.getSelectedValues();
                    for(int i=0;i<values.length;i++){
                        M2.addElement(values[i].toString());
                        M1.removeElement(values[i].toString());
                        
                    }

                }
            });

            B2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    Object[] values=L2.getSelectedValues();
                    for(int i=0;i<values.length;i++){
                        M1.addElement(values[i].toString());
                        M2.removeElement(values[i].toString());
   
                    }
                }
            });

            B3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    int tmp=M1.getSize();
                    for(int i=0;i<tmp;i++){
                        M2.addElement(M1.getElementAt(0));
                        M1.removeElementAt(0);
                    }
                }
            });

            B4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    int tmp=M2.getSize();
                    for(int i=0;i<tmp;i++){
                        M1.addElement(M2.getElementAt(0));
                        M2.removeElementAt(0);
                    }
                    
                }
            });

            P.add(new JScrollPane(L1));
            P.add(ButtonPanel);
            P.add(new JScrollPane(L2));
            
            F.getContentPane().add(P);
            
            F.setSize(400,400); 
            F.setVisible(true); 
        }
    });
}
}
