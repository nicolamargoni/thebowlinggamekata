public class Frame {
    private int[] rolls;
    private int rollIndex;
    private boolean isLast = false;

    public Frame(int[] rolls, int rollIndex) {
        this.rolls = rolls;
        this.rollIndex = rollIndex;
    }

    public Frame(int[] rolls, int rollIndex, boolean isLast) {
        this.rolls = rolls;
        this.rollIndex = rollIndex;
        this.isLast = isLast;
    }

    public int score() {
        if (isStrike()) {
            return 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
        }

        if (isSpare()) {
            return 10 + rolls[rollIndex + 2];
        }

        int score = 0;
        for (int index = rollIndex; index < rollIndex + 2; index++) {
            if (rollExecuted(rolls[index])) {
                score += rolls[index];
            }
        }
        return score;
    }

    public boolean isTerminated() {
        if (isLast) {
            if (isSpare() && !thirdRollExecuted()) {
                return false;
            }
            return firstRollExecuted() &&
                    secondRollExecuted();
        } else {
            if (isStrike()) {
                return true;
            }
            return firstRollExecuted() &&
                    secondRollExecuted();
        }
    }

    public boolean isSpare() {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

    public boolean isStrike() {
        return rolls[rollIndex] == 10;
    }

    public boolean rollExecuted(int roll) {
        return roll != Game.ROLL_NOT_EXECUTED;
    }

    public boolean firstRollExecuted() {
        return rollExecuted(rolls[rollIndex]);
    }

    public boolean secondRollExecuted() {
        return rollExecuted(rolls[rollIndex + 1]);
    }

    public boolean thirdRollExecuted() {
        return rollExecuted(rolls[rollIndex + 2]);
    }


}
