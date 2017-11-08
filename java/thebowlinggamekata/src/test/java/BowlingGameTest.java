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
    public void simpleSpare() throws Exception {
        game.roll(6);
        game.roll(4);
        game.roll(5);

        assertEquals(20, game.score());
    }

    @Test
    public void simpleStrike() throws Exception {
        game.roll(10);
        game.roll(5);
        game.roll(3);

        assertEquals(26, game.score());
    }

    @Test
    public void mustFinishWithTwoNormalRollsAtLastFrame() throws Exception {
        doRolls(1, 20);

        assertTrue(game.isOver);
    }

    @Test
    public void mustNotFinishAfterSpareAtLastFrame() throws Exception {
        doRolls(1, 19);
        game.roll(9);

        assertFalse(game.isOver);
    }

    @Test
    public void mustNotFinishAfterTwoStriketLastFrame() throws Exception {
        doRolls(1, 18);
        doRolls(10,2);

        assertFalse(game.isOver);
    }


    public void doRolls(int pins, int times) {
        for (int rollIndex = 0; rollIndex < times; rollIndex++) {
            game.roll(pins);
        }
    }
}
