
import java.util.ArrayList;

public class Game {
    private ArrayList<Integer> rools = new ArrayList<Integer>();
    private ArrayList<Frame> frames;
    private int roll = 1;
    private Frame currentFrame;
    private int frameIndex = 0;

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
        rools.add(pins);
        switch (roll) {
            case 1:
                newFrame();
                currentFrame.addRoll(pins);
                roll++;
                break;
            case 2:
                currentFrame.addRoll(pins);
                roll--;
                break;
        }
    }

    public void newFrame() {
        frameIndex = frames.size();
        frames.add(new Frame());
        currentFrame = frames.get(frameIndex);
    }
}
