package temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class FinalNarrow {
    private JFrame frame;
    private JPanel panel;
    private JLabel question;
    private JButton yesButton;
    private JButton noButton;
    private Career[] topCareers;

    private int careerIndex = 0;
    private int questionIndex = 0;

    private static Map<String, String[][]> careerQuestions = new HashMap<String, String[][]>() {{
        put("Art", new String[][]{
                {"Do you enjoy creating visual or performing arts?", "Do you have a strong sense of aesthetics and design?"},
        });
        put("Business", new String[][]{
                {"Do you enjoy managing projects and leading teams?", "Are you interested in finance, marketing, or entrepreneurship?"},
        });
        put("Education", new String[][]{
                {"Do you enjoy teaching and helping others learn?", "Are you patient and able to communicate complex ideas effectively?"},
        });
        put("Engineering", new String[][]{
                {"Do you enjoy solving complex problems using math and science?", "Do you have strong analytical and critical thinking skills?"},
        });
        put("Healthcare", new String[][]{
                {"Do you enjoy helping others and providing healthcare services?", "Are you comfortable working in medical environments?"},
        });
        put("Law", new String[][]{
                {"Do you enjoy analyzing legal issues and defending clients?", "Are you able to think critically and communicate persuasively?"},
        });
        put("Technology", new String[][]{
                {"Do you enjoy working with computers and learning new technologies?", "Are you able to solve problems using logic and algorithms?"},
        });
        put("Trades", new String[][]{
                {"Do you enjoy working with your hands and building things?", "Are you comfortable working in various environments and locations?"},
        });
    }};

    public FinalNarrow(Career career1, Career career2, Career career3) {
        topCareers = new Career[]{career1, career2, career3};

        frame = new JFrame("Final Narrow");
        frame.setIconImage(new ImageIcon("C:/Users/Arshi/git/CareerQuiz/CareerQuiz/src/temp/Icon.png").getImage());
        frame.setSize(600, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(new Color(0, 255, 255));
        frame.getContentPane().add(panel);

        String careerName = topCareers[careerIndex].getClass().getSimpleName();
        panel.setLayout(null);
        question = new JLabel(careerQuestions.get(careerName)[0][questionIndex]);
        question.setBounds(22, 99, 537, 26);
        question.setHorizontalAlignment(SwingConstants.CENTER);
        question.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        panel.add(question);

        yesButton = new JButton("Yes");
        yesButton.setBounds(225, 130, 116, 39);
        yesButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        panel.add(yesButton );
                                                        yesButton.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                // Add points to the career based on the answer
                                                                topCareers[careerIndex].points++;

                                                                // Move to the next question or career
                                                                nextQuestionOrCareer();
                                                            }
                                                        });
                                                
                                                        noButton = new JButton("No");
                                                        noButton.setBounds(225, 174, 116, 39);
                                                        noButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
                                                        panel.add(noButton);
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move to the next question or career
                nextQuestionOrCareer();
            }
        });

        frame.setVisible(true);
    }
    private void nextQuestionOrCareer() {
        questionIndex++;
        String careerName = topCareers[careerIndex].getClass().getSimpleName();
        if (questionIndex < careerQuestions.get(careerName).length) {
            question.setText(careerQuestions.get(careerName)[0][questionIndex]);
        } else {
            careerIndex++;
            if (careerIndex < topCareers.length) {
                questionIndex = 0;
                careerName = topCareers[careerIndex].getClass().getSimpleName();
                question.setText(careerQuestions.get(careerName)[0][questionIndex]);
            } else {
                displayFinalResult();
            }
        }
    }

    private void displayFinalResult() {
        frame.dispose();
        Career bestCareer = topCareers[0];
        for (int i = 1; i < topCareers.length; i++) {
            if (topCareers[i].points > bestCareer.points) {
                bestCareer = topCareers[i];
            }
        }

        JFrame resultFrame = new JFrame("Career Recommendation");
        resultFrame.setSize(400, 200);
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel resultPanel = new JPanel();
        resultFrame.getContentPane().add(resultPanel);
        resultPanel.setLayout(new GridLayout(2, 1));

        JLabel resultLabel = new JLabel("Your best career recommendation:");
        resultPanel.add(resultLabel);

        JLabel careerLabel = new JLabel(bestCareer.getClass().getSimpleName());
        resultPanel.add(careerLabel);

        resultFrame.setVisible(true);
    }

}