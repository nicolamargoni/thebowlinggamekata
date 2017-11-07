public class Frame {
    private int nRolls;
    private int[] rolls = new int[3];

    public void addRoll(int pins) {
        rolls[nRolls++] = pins;
    }

    public int score() {
        int score = 0;
        for (int roll : rolls) {
            score += roll;
        }
        return score;
    }
}
