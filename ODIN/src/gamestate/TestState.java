package gamestate;

import odin.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TestState extends GameState {
    
    private GameStateManager manager;

    public TestState(GameStateManager gsm)
    {
        this.manager = gsm;
        init();
    }

    public void init()
    {
//        tileMap = new TileMap(30);
//        tileMap.loadTiles("/resources/Tilesets/grasstileset.gif");
//        tileMap.loadMap("/resources/Maps/level1-1.map");
//        tileMap.setPosition(0, 0);
//        tileMap.setTween(1);
//
//        bg = new Background("/resources/Backgrounds/grassbg1.png", 0.1);
//
//        player = new Player(tileMap);
//        player.setPosition(100, 100);
    }


    public void update()
    {
        // update player
//        player.update();
//        tileMap.setPosition(
//            GamePanel.WIDTH / 2 - player.getx(),
//            GamePanel.HEIGHT / 2 - player.gety()
//        );
    }

    public void draw(Graphics2D g)
    {
        g.clearRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
//        // draw bg
//        bg.draw(g);
//
//        // draw tilemap
//        tileMap.draw(g);
//
//        // draw player
//        player.draw(g);
    }

    public void keyPressed(int k)
    {
//        if(k == KeyEvent.VK_LEFT) player.setLeft(true);
//        if(k == KeyEvent.VK_RIGHT) player.setRight(true);
//        if(k == KeyEvent.VK_SHIFT) player.setShouldRun(true);
//        if(k == KeyEvent.VK_UP) player.setUp(true);
//        if(k == KeyEvent.VK_DOWN) player.setDown(true);
//        if(k == KeyEvent.VK_W) player.setJumping(true);
    }

    public void keyReleased(int k)
    {
//        if(k == KeyEvent.VK_LEFT) player.setLeft(false);
//        if(k == KeyEvent.VK_RIGHT) player.setRight(false);
//        if(k == KeyEvent.VK_SHIFT) player.setShouldRun(false);
//        if(k == KeyEvent.VK_UP) player.setUp(false);
//        if(k == KeyEvent.VK_DOWN) player.setDown(false);
//        if(k == KeyEvent.VK_W) player.setJumping(false);
    }	
}