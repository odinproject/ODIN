package odin;

import gamestate.GameStateManager;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener
{

    // dimensions
    // 1250 x 768 : iPad
    // 1250 x 750 : clean split
    // 1000 x 600 : clean spit reduced
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    public static final int SCALE = 1;

    // game thread
    private Thread thread;
    private boolean running;
    private int FPS = 60;
    private long targetTime = 1000 / FPS;
    
    // input
    private ArrayList<Integer> pressedKeys;

    // image
    private BufferedImage image;
    private Graphics2D g;

    // game state manager
    private GameStateManager gsm;

    public GamePanel()
    {
        super();
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify()
    {
        super.addNotify();
        if(thread == null)
        {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    private void init()
    {
        running = true;
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        gsm = new GameStateManager(this);
    }
    
    public void run()
    {
        init();

        long start;
        long elapsed;
        long wait;

        // game loop
        while(running)
        {
            start = System.nanoTime();

            update();
            draw();
            drawToScreen();

            elapsed = System.nanoTime() - start;

            wait = targetTime - elapsed / 1000000;
            if(wait < 0) wait = 5;

            try {
                Thread.sleep(wait);
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        gsm.update();
    }
    private void draw() {
        gsm.draw(g);
    }
    private void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0,
                        WIDTH * SCALE, HEIGHT * SCALE,
                        null);
        g2.dispose();
    }

    public void keyTyped(KeyEvent key)
    {
        
    }
    public void keyPressed(KeyEvent key)
    {
        int keyCode = key.getKeyCode();
        gsm.keyPressed(keyCode);
        pressedKeys.add(keyCode);
    }
    public void keyReleased(KeyEvent key)
    {
        int keyCode = key.getKeyCode();
        gsm.keyReleased(keyCode);
        pressedKeys.remove(keyCode);
    }
}