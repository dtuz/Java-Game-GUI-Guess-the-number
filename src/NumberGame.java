import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGame {
    private static final String GUESS_TEXT = "Your number is: ";

    private double guessedNumber;
    private double lowLimit;
    private double highLimit;
    private int counter = 0;

    private JPanel NumberGame;
    private JTextField textField;
    private JButton buttonSmaller;
    private JButton buttonGreater;
    private JTextField attempts;
    private JButton buttonStart;
    private JButton buttonGuessedNumber;
    private JLabel GameLabel;
    private final JFrame frame;

    public NumberGame() {
        buttonSmaller.setVisible(false);
        buttonGuessedNumber.setVisible(false);
        buttonGreater.setVisible(false);
        textField.setFocusable(false);
        attempts.setFocusable(false);

        frame = new JFrame("Input Dialog Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGameState(true);
            }
        });
        buttonSmaller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lowLimit == guessedNumber - 1) {
                    guessedNumber--;
                    setGameState(false);
                    return;
                }

                highLimit = (int) guessedNumber;

                updateAttempts();
            }
        });
        buttonGreater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (highLimit == guessedNumber + 1) {
                    guessedNumber++;
                    setGameState(false);
                    return;
                }

                lowLimit = (int) guessedNumber;

                updateAttempts();
            }
        });
        buttonGuessedNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGameState(false);
            }
        });
    }

    private void updateAttempts() {
        guessedNumber = Math.floor((highLimit + lowLimit) / 2);
        textField.setText(GUESS_TEXT + ((int) guessedNumber) + "?");
        counter++;
        attempts.setText(String.valueOf(counter));
    }

    private void setGameState(boolean state) {
        buttonSmaller.setVisible(state);
        buttonGreater.setVisible(state);
        buttonGuessedNumber.setVisible(state);
        buttonStart.setVisible(!state);

        if (state) {
            counter = 1;
            guessedNumber = 50;
            lowLimit = 1;
            highLimit = 100;

            textField.setText(GUESS_TEXT + ((int) guessedNumber) + "?");
            attempts.setText(String.valueOf(counter));
            return;
        }

        textField.setText("");
        attempts.setText("");
        String message = "<html>The number you wished is: " + (int) guessedNumber + "<br>I guessed it in " + counter + " tries</html>";
        JOptionPane.showMessageDialog(frame, message, "Victory", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NumberGame");
        frame.setContentPane(new NumberGame().NumberGame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
