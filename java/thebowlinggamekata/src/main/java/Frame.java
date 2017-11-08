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
        int score = 0;
        for (int index = rollIndex; index < rollIndex + 2; index++) {
            if (rolls[index] != Game.ROLL_NOT_EXECUTED) {
                score += rolls[index];
            }
        }
        return score;
    }

    public boolean isTerminated() {
        if (isLast) {
            return rolls[rollIndex] != Game.ROLL_NOT_EXECUTED
                    && rolls[rollIndex + 1] != Game.ROLL_NOT_EXECUTED
                    && rolls[rollIndex + 2] != Game.ROLL_NOT_EXECUTED;
        } else {
            return rolls[rollIndex] != Game.ROLL_NOT_EXECUTED
                    && rolls[rollIndex + 1] != Game.ROLL_NOT_EXECUTED;
        }
    }


}
