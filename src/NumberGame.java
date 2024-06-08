import javax.swing.*;

public class NumberGame {
    private JPanel NumberGame;
    private JLabel GameLabel;
    private JTextField textField;
    private JButton buttonSmaller;
    private JButton buttonGreater;
    private JTextField attempts;

    public NumberGame(){
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NumberGame");
        frame.setContentPane(new NumberGame().NumberGame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
