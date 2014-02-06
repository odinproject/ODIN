package gamestate;

import odin.GamePanel;
import java.util.ArrayList;

public class GameStateManager
{
    private ArrayList<GameState> gameStates;
    public int currentState;

    private GamePanel panel;

    public static final int TESTSTATE = 0;

    public GameStateManager(GamePanel panel)
    {
        this.panel = panel;
        gameStates = new ArrayList<GameState>();

        currentState = TESTSTATE;
        gameStates.add(new TestState(this));
    }

    public void setState(int state)
    {
        currentState = state;
        gameStates.get(currentState).init();
    }

    public void update()
    {
        gameStates.get(currentState).update();
    }

    public void draw(java.awt.Graphics2D g)
    {
        gameStates.get(currentState).draw(g);
    }

    public void keyPressed(int k)
    {
        gameStates.get(currentState).keyPressed(k);
    }

    public void keyReleased(int k)
    {
        gameStates.get(currentState).keyReleased(k);
    }
}