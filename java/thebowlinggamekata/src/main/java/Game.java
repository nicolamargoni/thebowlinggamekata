
import java.util.ArrayList;

public class Game {
    private int[] rools = new int[21];
    private int rollIndex = -1;

    private Frame currentFrame;
    private ArrayList<Frame> frames;
    private int frameIndex = 0;

    private int roll = 1;

    public Game(ArrayList<Frame> frames) {
        this.frames = frames;
    }

    public int score() {
        int score = 0;
        for (Frame frame : frames) {
            score += frame.score();
        }
        return score;
    }

    public void roll(int pins) {
        addRoll(pins);
        switch (roll) {
            case 1:
                newFrame();
                currentFrame.addRoll(pins);
                roll++;
                break;
            case 2:
                currentFrame.addRoll(pins);
                if (isNotLastFrame()) {
                    roll--;
                    break;
                } else {
                    roll++;
                    break;
                }
            case 3:
                currentFrame.addRoll(pins);
                break;
        }
    }

    public void addRoll(int pins) {
        rollIndex++;
        rools[rollIndex] = pins;
    }

    public void newFrame() {
        frameIndex = frames.size();
        frames.add(new Frame());
        currentFrame = frames.get(frameIndex);
    }

    public boolean isNotLastFrame() {
        return frameIndex != 9;
    }
}
