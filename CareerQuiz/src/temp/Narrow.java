package temp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Narrow {
    private JFrame frame;
    private JPanel panel;
    private JLabel result;
    private JButton continueButton;

    private Engineering engineering;
    private Healthcare healthcare;
    private Business business;
    private Art art;
    private Trades trades;
    private Education education;
    private Technology technology;
    private Law law;

    private Career[] careers;

    public Narrow(String[] answers) {
        engineering = new Engineering(answers);
        healthcare = new Healthcare(answers);
        business = new Business(answers);
        art = new Art(answers);
        trades = new Trades(answers);
        education = new Education(answers);
        technology = new Technology(answers);
        law = new Law(answers);

        frame = new JFrame("Top 3 Career Options");
        frame.setIconImage(new ImageIcon("C:/Users/Arshi/git/CareerQuiz/CareerQuiz/src/temp/Icon.png").getImage());
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(new Color(0, 255, 255));
        frame.getContentPane().add(panel);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints b = new GridBagConstraints();
        
        result = new JLabel("Top 3 Career Options:");
        c.gridx = 0;
        c.gridy = 0;
        panel.add(result, b);

        getTopThree();

        continueButton = new JButton("Continue");
        c.gridx = 1;
        c.gridy = 3;
        panel.add(continueButton, c);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FinalNarrow finalNarrow = new FinalNarrow(careers[0], careers[1], careers[2]);
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    private void getTopThree() {
        careers = new Career[]{engineering, healthcare, business, art, trades, education, technology, law};
        Arrays.sort(careers, Comparator.comparingInt(Career::getPoints).reversed());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;

        for (int i = 0; i < 3; i++) {
            c.gridy = i + 1;
            JLabel option = new JLabel((i + 1) + ". " + careers[i].getClass().getSimpleName());
            panel.add(option, c);
        }
    }
}