import javax.swing.*;        

public class HelloWorldSwing
{

    private static void initGUI() 
    {
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
        label.setHorizontalAlignment(JLabel.CENTER);

        frame.pack();
        frame.setSize(400,400);
        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run()
            {
                initGUI();
            }
        });
    }
}
