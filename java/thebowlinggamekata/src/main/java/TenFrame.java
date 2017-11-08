public class TenFrame extends Frame {

    public TenFrame(int[] rolls, int rollIndex) {
        super(rolls, rollIndex);
    }

    @Override
    public int score() {
        if (madeStrike()) {
            return 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
        }

        if (madeSpare()) {
            return 10 + 2 * rolls[rollIndex + 2];
        }

        int score = 0;
        for (int index = rollIndex; index < rollIndex + 2; index++) {
            if (rollExecuted(rolls[index])) {
                score += rolls[index];
            }
        }
        return score;
    }

    @Override
    public boolean isTerminated() {

        if (madeSpare() && !thirdRollExecuted()) {
            return false;
        }

        if (thereAreTwoStrikes() && !thirdRollExecuted()) {
            return false;
        }

        return firstRollExecuted() &&
                secondRollExecuted();
    }

    public boolean thirdRollExecuted() {
        return rollExecuted(rolls[rollIndex + 2]);
    }

    public boolean thereAreTwoStrikes() {
        return rolls[rollIndex] == 10 && rolls[rollIndex + 1] == 10;
    }
}