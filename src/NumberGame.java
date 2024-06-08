import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGame {
    private int guessedNumber;
    private int lowLimit = 0;
    private int highLimit = 100;
    private int counter = 0;

    private JPanel NumberGame;
    private JLabel GameLabel;
    private JTextField textField;
    private JButton buttonSmaller;
    private JButton buttonGreater;
    private JTextField attempts;
    private JButton buttonStart;

    public NumberGame(){
        buttonSmaller.setEnabled(false);
        buttonGreater.setEnabled(false);
        textField.setFocusable(false);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessedNumber = (highLimit + lowLimit) / 2;
                buttonSmaller.setEnabled(true);
                buttonGreater.setEnabled(true);
                buttonStart.setEnabled(false);
                textField.setText(textField.getText() + String.valueOf(guessedNumber) + "?");
                counter++;
                attempts.setText(String.valueOf(counter));
            }
        });
        buttonSmaller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                highLimit = guessedNumber;
                guessedNumber = highLimit / 2;

                textField.setText( String.valueOf(guessedNumber) + "?");
                counter++;
                attempts.setText(String.valueOf(counter));

            }
        });
        buttonGreater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowLimit = guessedNumber;
                guessedNumber = (highLimit + guessedNumber) / 2;

                textField.setText( String.valueOf(guessedNumber) + "?");
                counter++;
                attempts.setText(String.valueOf(counter));
                
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NumberGame");
        frame.setContentPane(new NumberGame().NumberGame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
