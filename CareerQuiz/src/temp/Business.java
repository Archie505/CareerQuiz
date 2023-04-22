package temp;

public class Business extends Career {
    public Business(String[] answers) {
        super(answers);
    }

    protected void determinePoints() {
        points = 0;
        
        if (answers[0].equals("yes")) {
            // Add points based on the answer to question 1
            //points++;
        }
        if (answers[1].equals("yes")) {
            // Add points based on the answer to question 2
            points++;
        }
        if (answers[2].equals("yes")) {
            // Add points based on the answer to question 3
            points++;
        }
        if (answers[3].equals("yes")) {
            // Add points based on the answer to question 4
            points++;
        }
        if (answers[4].equals("yes")) {
            // Add points based on the answer to question 4
            points++;
        }
        if (answers[5].equals("yes")) {
            // Add points based on the answer to question 4
            points++;
        }
        if (answers[6].equals("yes")) {
            // Add points based on the answer to question 4
            //points++;
        }
        if (answers[7].equals("yes")) {
            // Add points based on the answer to question 4
            points++;
        }
        if (answers[8].equals("yes")) {
            // Add points based on the answer to question 4
            //points++;
        }
        if (answers[9].equals("yes")) {
            // Add points based on the answer to question 4
            points++;
        }
}
}