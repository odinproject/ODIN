package odin;

import javax.swing.JFrame;

/**
 *
 * @author Martin
 */
public class ODIN
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        JFrame window = new JFrame("ODIN Engine");
        window.setContentPane(new GamePanel());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);
    }
}
