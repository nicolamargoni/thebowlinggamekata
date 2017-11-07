public class Game {
    private int[] rools = new int[21];
    private Frame[] frames = new Frame[10];
    public int nRolls = 0;
    public int nFrames = 0;

    public Game() {
        for (int frameIndex = 0; frameIndex < frames.length; frameIndex++) {
            frames[frameIndex] = new Frame();
        }
    }

    public int score() {
        int score = 0;
        for (Frame frame : frames) {
            score += frame.score();
        }
        return score;
    }

    public void roll(int pins) {
        rools[nRolls] = pins;
        frames[nFrames].addRoll(pins);
        nRolls++;
    }
}
