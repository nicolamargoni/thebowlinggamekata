import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
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
    public void spare() throws Exception {
        game.roll(6);
        game.roll(4);
        game.roll(5);
        assertEquals(20, game.score());
    }


}
