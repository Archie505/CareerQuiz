
package temp;
public abstract class Career {
    protected String[] answers;
    protected int points;

    public Career(String[] answers) {
        this.answers = answers;
        determinePoints();
    }

    protected abstract void determinePoints();

    public int getPoints() {
        return points;
    }
}