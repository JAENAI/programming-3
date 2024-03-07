import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Trees
{



public static void main(String[] args)
{
    
    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
        public void run()
        {
            JFrame    F    =    new    JFrame();
            F.setTitle("Swing JTree");                         
            F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel    P    =    new    JPanel(new BorderLayout());
            
            DefaultMutableTreeNode    root    =    new    DefaultMutableTreeNode("Root");
            
            DefaultMutableTreeNode    fruit    =    new    DefaultMutableTreeNode("Fruits");
            root.add(fruit);
            
            fruit.add(new    DefaultMutableTreeNode("Oranges"));
            fruit.add(new    DefaultMutableTreeNode("Bananas"));
            fruit.add(new    DefaultMutableTreeNode("Apples"));
            
            // ADD THE VEGETABLES
            DefaultMutableTreeNode vegetable = new DefaultMutableTreeNode("Vegetables");
            root.add(vegetable);

            vegetable.add(new    DefaultMutableTreeNode("Tomatoes"));
            vegetable.add(new    DefaultMutableTreeNode("Potatoes"));
            vegetable.add(new    DefaultMutableTreeNode("Carrots"));
            

            
            final JTree    T    =    new    JTree(root);
            final JLabel    L    =    new JLabel("-");
            L.setHorizontalAlignment(JLabel.CENTER);
            P.add(T, BorderLayout.WEST);
            P.add(L, BorderLayout.CENTER);

            
            // ADD LISTENER TO DISPLAY THE PATH ON PANEL

            T.addTreeSelectionListener(new TreeSelectionListener() {
                @Override
                public void valueChanged(TreeSelectionEvent e){
                    Object[] path=T.getSelectionPath().getPath();
                    String p="[";
                    for(int i=0;i<path.length;i++){
                        p+=((DefaultMutableTreeNode)path[i]).toString().toUpperCase();
                        if(i+1!=path.length){
                            p+=",";
                        }
                        
                    }
                    p+="]";
                    L.setText(p);

                }
            });
            
            
            
            F.getContentPane().add(P);
            
            JPanel    Panel2    =    new    JPanel(new GridLayout(1,2));
            final JTextField    A    =    new    JTextField();
            JButton        B    =    new    JButton("add as child");
            B.addActionListener(new ActionListener()
            {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                

                // NEEDED FOR REFRESH
                DefaultTreeModel model=(DefaultTreeModel)T.getModel();
                
                // ADD cHILD TO NODE
                if(((DefaultMutableTreeNode)T.getLastSelectedPathComponent()).equals(fruit)){
                    fruit.add(new DefaultMutableTreeNode(A.getText()));
                    model.reload(fruit);
                }
                if(((DefaultMutableTreeNode)T.getLastSelectedPathComponent()).equals(vegetable)){
                    vegetable.add(new DefaultMutableTreeNode(A.getText()));
                    model.reload(vegetable);
                }
                
                
                T.repaint();
            }
            });
            
            
            Panel2.add(A);
            Panel2.add(B);
            F.getContentPane().add(Panel2,BorderLayout.SOUTH);
            
            
            F.setSize(400,400); 
            F.setVisible(true); 
        }
    });
}
}