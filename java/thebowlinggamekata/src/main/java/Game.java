import java.util.ArrayList;

public class Game {
    private int[] rools = new int[20];
    private int roolsNumber = 0;


    public int score() {
        int gameScore = 0;
        int frameScore = 0;
        int roll = 1;
        boolean spare = false;

        for (int i = 0; i < roolsNumber; i++) {
            if (spare) {
                frameScore += 2 * rools[i];
            } else {
                frameScore += rools[i];
            }

            if (isFirstRollOfFrame(roll)) {
                if (isLastRool(i)) {
                    gameScore += frameScore;
                }
                roll++;
            } else {
                if (isSpare(frameScore)) {
                    spare = true;
                }
                roll--;
                gameScore += frameScore;
                frameScore = 0;
            }
        }
        return gameScore;
    }

    public void roll(int pins) {
        rools[roolsNumber] = pins;
        roolsNumber++;
    }

    public boolean isSpare(int score) {
        return score == 10;
    }

    public boolean isFirstRollOfFrame(int roll) {
        return roll == 1;
    }

    public boolean isLastRool(int roll) {
        return roll == (roolsNumber - 1);
    }
}
