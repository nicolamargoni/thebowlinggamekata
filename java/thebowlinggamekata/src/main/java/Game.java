
import java.util.ArrayList;

public class Game {
    public static final int ROLL_NOT_EXECUTED = -1;

    private int[] rolls = new int[21];
    private int rollIndex = 0;

    private Frame currentFrame;
    private ArrayList<Frame> frames;

    public boolean isOver;

    public Game(ArrayList<Frame> frames) {
        this.frames = frames;
        initRolls();
        isOver = false;
        newFrame();
    }

    public int score() {
        int score = 0;
        for (Frame frame : frames) {
            score += frame.score();
        }
        return score;
    }

    public void roll(int pins) {
        if (!isOver) {
            addRoll(pins);
            if (currentFrame.isTerminated()) {
                if (isLastFrame()) {
                    isOver = true;
                } else {
                    newFrame();
                }
            }
        }
    }

    public void addRoll(int pins) {
        rolls[rollIndex++] = pins;
    }

    public void newFrame() {
        if (isNotLastFrame()) {
            currentFrame = new Frame(rolls, rollIndex);
        } else {
            currentFrame = new TenFrame(rolls, rollIndex);
        }

        frames.add(currentFrame);
    }

    public boolean isNotLastFrame() {
        return frames.size() != 9;
    }

    public boolean isLastFrame() {
        return frames.size() == 10;
    }

    public void initRolls() {
        for (int index = 0; index < 21; index++) {
            rolls[index] = ROLL_NOT_EXECUTED;
        }
    }
}
