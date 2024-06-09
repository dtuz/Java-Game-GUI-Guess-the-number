import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGame {
    private double guessedNumber;
    private double lowLimit = 0;
    private double highLimit = 100;
    private int counter = 0;

    private JPanel NumberGame;
    private JLabel GameLabel;
    private JTextField textField;
    private JButton buttonSmaller;
    private JButton buttonGreater;
    private JTextField attempts;
    private JButton buttonStart;

    public NumberGame(){
        buttonSmaller.setVisible(false);
        buttonGreater.setVisible(false);
        textField.setFocusable(false);
        attempts.setFocusable(false);

        JFrame frame = new JFrame("Input Dialog Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessedNumber = (highLimit + lowLimit) / 2;
                buttonSmaller.setVisible(true);
                buttonGreater.setVisible(true);
                buttonStart.setEnabled(false);
                textField.setText(textField.getText() + String.valueOf((int) guessedNumber) + "?");
                counter++;
                attempts.setText(String.valueOf(counter));
            }
        });
        buttonSmaller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(highLimit == guessedNumber + 1 || lowLimit == guessedNumber - 1){
                    JOptionPane.showMessageDialog(frame, "Your number is: " + guessedNumber, "Victory", JOptionPane.INFORMATION_MESSAGE);
                }

                highLimit = guessedNumber;
                guessedNumber = Math.floor((highLimit + lowLimit) / 2);

                textField.setText( String.valueOf((int) guessedNumber) + "?");
                counter++;
                attempts.setText(String.valueOf(counter));

            }
        });
        buttonGreater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "<html>The number you wished is: " + (int) guessedNumber + "<br>I guessed it in " + counter + " tries</html>";
                if(highLimit == guessedNumber + 1 || lowLimit == guessedNumber - 1){
                    JOptionPane.showMessageDialog(frame, message, "Victory", JOptionPane.INFORMATION_MESSAGE);
                }

                lowLimit = guessedNumber;
                guessedNumber = Math.ceil((highLimit + guessedNumber) / 2);

                textField.setText( String.valueOf((int) guessedNumber) + "?");
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

    void ShowMessage(double result){

    }
}
