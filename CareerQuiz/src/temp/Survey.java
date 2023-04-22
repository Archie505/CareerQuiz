
package temp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Survey {
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel question;
    private static JButton yesButton;
    private static JButton noButton;

    private static String[] answers = new String[10];
    private static int questionIndex = 0;
    private static String[] questions = {
            "Do you prefer to work independently?",
            "Do you prefer to work with numbers and words?",
            "Are you comfortable with public speaking or presenting?",
            "Are you interested in working with technology or software?",
            "Do you enjoy working under pressure and meeting deadlines?",
            "Are you willing to travel for work?",
            "Do you prefer a flexible work schedule?",
            "Are you interested in working in a fast-paced environment?",
            "Are you interested in a career that involves physical labor?",
            "Would you be okay with working in an office?"
    };

    public static void main(String[] args) {
    	
    	
        frame = new JFrame("Job Assessment Survey");
        frame.setIconImage(new ImageIcon("C:/Users/Arshi/git/CareerQuiz/CareerQuiz/src/temp/Icon.png").getImage()); // set icon
        frame.setBackground(new Color(128, 255, 255));
        frame.setSize(577, 348);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(new Color(0, 255, 255));
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        question = new JLabel(questions[questionIndex]);
        question.setHorizontalAlignment(SwingConstants.CENTER);
        question.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        question.setBounds(0, 10, 563, 87);
        question.setBackground(new Color(240, 240, 240));
        panel.add(question);

        yesButton = new JButton("Yes");
        yesButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        yesButton.setBounds(176, 88, 183, 67);
        panel.add(yesButton);
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answers[questionIndex] = "yes";
                questionIndex++;
                if (questionIndex < questions.length) {
                    question.setText(questions[questionIndex]);
                } else {
                    Narrow narrow = new Narrow(answers);
                    frame.dispose();
                }
            }
        });
        yesButton.addMouseListener(new MouseAdapter() {
           public void mouseEntered(MouseEvent me) {
              yesButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
           }
           public void mouseExited(MouseEvent me) {
              yesButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
           }
        });

        noButton = new JButton("No");
        noButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        noButton.setBounds(176, 175, 183, 67);
        panel.add(noButton);
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answers[questionIndex] = "no";
                questionIndex++;
                if (questionIndex < questions.length) {
                    question.setText(questions[questionIndex]);
                } else {
                    Narrow narrow = new Narrow(answers);
                    frame.dispose();
                }
            }
        });
        noButton.addMouseListener(new MouseAdapter() {
           public void mouseEntered(MouseEvent me) {
              noButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
           }
           public void mouseExited(MouseEvent me) {
              noButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
           }
        });

        frame.setVisible(true);
    }
}