package SimpleCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {

    private JTextField displayField;
    private Calculator calculator;
    private boolean decimalClicked;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGUI::new);
    }

    public CalculatorGUI() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        calculator = new Calculator();
        decimalClicked = false;

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setEditable(false);
        contentPane.add(displayField, BorderLayout.NORTH);
        displayField.setPreferredSize(new Dimension(300, 50));
        displayField.setFont(new Font("Arial", Font.PLAIN, 40));
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 5));

        String[] buttonLabels = {
                "1", "2", "3", "/", "√",
                "4", "5", "6", "*", "x^2",
                "7", "8", "9", "-", "%",
                ".", "0", "+", "(-)", "=",
                "C", "<-" 
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        contentPane.add(buttonPanel, BorderLayout.CENTER);

        setContentPane(contentPane);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (Character.isDigit(command.charAt(0))) {
            displayField.setText(displayField.getText() + command);
        } else if (command.equals(".")) {
            if (!decimalClicked) {
                displayField.setText(displayField.getText() + ".");
                decimalClicked = true;
            }
        } else if (command.equals("C")) {
            displayField.setText("");
            decimalClicked = false;
        } else if (command.equals("<-")) { 
            String currentText = displayField.getText();
            if (currentText.length() > 0) {
                displayField.setText(currentText.substring(0, currentText.length() - 1));
            }
        } else if (command.equals("=")) {
            try {
                double result = calculator.calculate(displayField.getText());
                displayField.setText(Double.toString(result));
            } catch (ArithmeticException ex) {
                displayField.setText("Error: " + ex.getMessage());
            }
            decimalClicked = false;
        } else if (command.equals("√")) {
            displayField.setText(displayField.getText() + "√");
            decimalClicked = false;
        } else if (command.equals("x^2")) { 
            displayField.setText(displayField.getText() + "^2");
            decimalClicked = false;
        } else if (command.equals("%")) { 
            displayField.setText(displayField.getText() + "%");
            decimalClicked = false;
        } else if (command.equals("(-)")) { 
            displayField.setText(displayField.getText() + "(-)");
            decimalClicked = false;
        } else {
            displayField.setText(displayField.getText() + " " + command + " ");
            decimalClicked = false;
        }
    }
}
