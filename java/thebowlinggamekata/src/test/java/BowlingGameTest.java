import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest {

    @Test
    public void createGame() throws Exception {
        Game game = new Game();
    }

    @Test
    public void scoreGame() throws Exception {
        Game game = new Game();
        assertEquals(0, game.score());
    }

    @Test
    public void firstRoll() throws Exception {
        Game game = new Game();
        game.roll(5);
        assertEquals(5, game.score());
    }


}
