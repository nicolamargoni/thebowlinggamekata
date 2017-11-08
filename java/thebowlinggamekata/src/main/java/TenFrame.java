public class TenFrame extends Frame {

    public TenFrame(int[] rolls, int rollIndex) {
        super(rolls, rollIndex);
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