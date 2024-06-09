import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGame {
    private double guessedNumber;
    private double lowLimit = 1;
    private double highLimit = 101;
    private int counter = 0;

    private JPanel NumberGame;
    private JLabel GameLabel;
    private JTextField textField;
    private JButton buttonSmaller;
    private JButton buttonGreater;
    private JTextField attempts;
    private JButton buttonStart;
    private JButton buttonGuessedNumber;

    public NumberGame(){
        String text = textField.getText();
        buttonSmaller.setVisible(false);
        buttonGuessedNumber.setVisible(false);
        buttonGreater.setVisible(false);
        textField.setFocusable(false);
        attempts.setFocusable(false);
        JFrame frame = new JFrame("Input Dialog Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(highLimit != 100 && lowLimit != 0){
                    buttonSmaller.setVisible(false);
                    buttonGreater.setVisible(false);
                    textField.setText(text);
                    counter = 0;
                }

                guessedNumber = 50;
                buttonSmaller.setVisible(true);
                buttonGreater.setVisible(true);
                buttonStart.setVisible(false);
                buttonGuessedNumber.setVisible(true);
                textField.setText(text + String.valueOf((int) guessedNumber) + "?");
                counter++;
                attempts.setText(String.valueOf(counter));
            }
        });
        buttonSmaller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "<html>The number you wished is: " + (int) guessedNumber + "<br>I guessed it in " + counter + " tries</html>";
                if
                (lowLimit == guessedNumber - 1){
                    JOptionPane.showMessageDialog(frame, message, "Victory", JOptionPane.INFORMATION_MESSAGE);
                    buttonStart.setVisible(true);
                    buttonGreater.setEnabled(false);
                    return;
                }

                highLimit = (int) guessedNumber;
                guessedNumber = Math.floor((highLimit + lowLimit) / 2);

                textField.setText(text + String.valueOf((int) guessedNumber) + "?");
                counter++;
                attempts.setText(String.valueOf(counter));

            }
        });
        buttonGreater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "<html>The number you wished is: " + (int) guessedNumber + "<br>I guessed it in " + counter + " tries</html>";
                if(highLimit == guessedNumber + 1){
                    JOptionPane.showMessageDialog(frame, message, "Victory", JOptionPane.INFORMATION_MESSAGE);
                    buttonStart.setVisible(true);
                    buttonSmaller.setVisible(false);
                    buttonGreater.setVisible(false);
                    buttonGuessedNumber.setVisible(false);
                    return;
                }

                lowLimit = (int) guessedNumber;
                guessedNumber = Math.floor((highLimit + guessedNumber) / 2);

                textField.setText(text + String.valueOf((int) guessedNumber) + "?");
                counter++;
                attempts.setText(String.valueOf(counter));

            }
        });
        buttonGuessedNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "<html>The number you wished is: " + (int) guessedNumber + "<br>I guessed it in " + counter + " tries</html>";

                JOptionPane.showMessageDialog(frame, message, "Victory", JOptionPane.INFORMATION_MESSAGE);

                buttonGuessedNumber.setVisible(false);
                buttonGreater.setVisible(false);
                buttonSmaller.setVisible(false);
                buttonStart.setVisible(true);
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
