
package temp;

public class Education extends Career {
    public Education(String[] answers) {
        super(answers);
    }

    @Override
    protected void determinePoints() {
        points = 0;
        for (int i = 0; i < answers.length; i++) {
            if (i == 0 && answers[i].equals("yes")) {
                points++;
            }
            // Add more conditions for other questions
        }
    }
}