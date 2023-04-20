package temp;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Narrow {
    private JFrame frame;
    private JPanel panel;
    private JLabel result;

    private Engineering engineering;
    private Healthcare healthcare;
    private Business business;
    private Art art;
    private Trades trades;
    private Education education;
    private Technology technology;
    private Law law;

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
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(4, 1));

        result = new JLabel("Top 3 Career Options:");
        panel.add(result);

        getTopThree();

        frame.setVisible(true);
    }

    private void getTopThree() {
        Career[] careers = {engineering, healthcare, business, art, trades, education, technology, law};
        Arrays.sort(careers, Comparator.comparingInt(Career::getPoints).reversed());
    
        JLabel first = new JLabel("1. " + careers[0].getClass().getSimpleName());
        JLabel second = new JLabel("2. " + careers[1].getClass().getSimpleName());
        JLabel third = new JLabel("3. " + careers[2].getClass().getSimpleName());
    
        panel.add(first);
        panel.add(second);
        panel.add(third);
    }
}