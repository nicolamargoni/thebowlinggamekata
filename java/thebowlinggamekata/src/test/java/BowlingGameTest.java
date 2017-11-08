import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BowlingGameTest {
    private ArrayList<Frame> frames;
    private Game game;

    @Before
    public void setUp() {
        frames = new ArrayList<Frame>();
        game = new Game(frames);
    }

    @Test
    public void initialScoreGame() throws Exception {
        int score = game.score();
        assertEquals(0, score);
    }

    @Test
    public void firstRoll() throws Exception {
        game.roll(5);
        assertEquals(5, game.score());
    }

    @Test
    public void secondRoll() throws Exception {
        game.roll(5);
        game.roll(4);
        assertEquals(9, game.score());
    }


    @Test
    public void thereMustBeThenFramesAfterTwentyOneRolls() throws Exception {
        doRolls();
        assertEquals(10, frames.size());
    }


    @Test
    public void spare() throws Exception {
        game.roll(6);
        game.roll(4);
        game.roll(5);
        assertEquals(20, game.score());
    }

    @Test
    public void strike() throws Exception {
        game.roll(10);
        game.roll(5);
        game.roll(3);
        assertEquals(26, game.score());
    }

    public void doRolls() {
        for (int rollIndex = 0; rollIndex < 21; rollIndex++) {
            game.roll(5);
        }
    }
}
