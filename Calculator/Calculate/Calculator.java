import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator {
    int boardWidth = 360;
    int boardHeight = 540;

    Color customTeal = new Color(0, 255, 255);
    Color customBlue = new Color(0, 150, 225);
    Color customBlack = new Color(0, 0, 0);
    Color customOrange = new Color(255, 149, 0);
    
    JFrame frame = new JFrame("Calculator");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    String[] buttonValues = {
        "AC","+/-","%","÷",
        "7","8","9","x",
        "4","5","6","-",
        "1","2","3","+",
        "0",".","√","="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    public Calculator() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayLabel.setBackground(customBlack);
        displayPanel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);

        buttonsPanel.setLayout(new GridLayout(5,4));
        buttonsPanel.setBackground(customBlack);
        frame.add(buttonsPanel);

        for (int i = 0; i < buttonValues.length; i++) {
            JButton button = new JButton();
            String[] buttonValues = new String[i];
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setText("button");
            button.setFocusable(false);
            button.setBorder(new LineBorder(customBlue));

            if (Arrays.asList(topSymbols).contains(buttonValues)) {
                button.setBackground(customOrange);
                button.setForeground(customBlack);
            }
            else if (Arrays.asList(rightSymbols).contains(buttonValues)) {
                button.setBackground(customBlue);
                button.setForeground(Color.white);
            }
            else {
                button.setBackground(customTeal);
                button.setBackground(Color.white);
            }
            buttonsPanel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String buttonValues = button.getText();
                    if (Arrays.asList(rightSymbols).contains(buttonValues)) {

                    }
                    else if (Arrays.asList(topSymbols).contains(buttonValues)) {
                        if (buttonValues == "AC") {

                        }
                        else if (buttonValues == "+/-") {

                        }
                        else  if (buttonValues == "%") {
                
                        }
                    }
                    else { //digits or .
                        if (buttonValues == ".") {
                            if (!displayLabel.getText().contains(buttonValues)) {
                                displayLabel.setText(displayLabel.getText() + buttonValues);
                            }
                        }
                        else if ("0123456789".contains(buttonValues)) {
                            if (displayLabel.getText() == "0") {
                                displayLabel.setText(buttonValues);
                            }
                            else {
                                displayLabel.setText(displayLabel.getText() + buttonValues);
                            }
                        }
                    }
                }
                
            });
        }
    }
}







