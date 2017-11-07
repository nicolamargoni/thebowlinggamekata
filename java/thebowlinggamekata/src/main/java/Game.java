import java.util.ArrayList;

public class Game {
    private int[] rools = new int[20];
    private int roolsNumber = 0;


    public int score() {
        int gameScore = 0;
        int frameScore = 0;
        int roll = 1;
        boolean madeSpare = false;
        boolean madeStrike = false;

        for (int i = 0; i < roolsNumber; i++) {
            frameScore += rools[i];

            if (isFirstRollOfFrame(roll)) {
                if (madeSpare) {
                    frameScore += rools[i];
                }

                if (isLastRool(i)) {
                    if (madeStrike) {
                        gameScore += 2 * frameScore;
                    } else {
                        gameScore += frameScore;
                    }
                }

                if (madeStrike) {
                    frameScore += rools[i];
                }

                if (isStrike(frameScore)) {
                    madeStrike = true;
                } else {
                    roll++;
                }

            } else {
                if (madeStrike) {
                    frameScore += rools[i];
                    gameScore += frameScore;
                } else {
                    gameScore += frameScore;
                }

                if (isSpare(frameScore)) {
                    madeSpare = true;
                } else {
                    madeSpare = false;
                }

                frameScore = 0;
                roll--;
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

    public boolean isStrike(int pins) {
        return pins == 10;
    }

    public boolean isFirstRollOfFrame(int roll) {
        return roll == 1;
    }

    public boolean isLastRool(int roll) {
        return roll == (roolsNumber - 1);
    }
}
