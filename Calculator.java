import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    // Declare all the components
    JTextField display;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    // Variables to hold the operands and operator
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    // Constructor
    public Calculator() {
        // Initialize the frame
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 550);
        this.setLayout(null);

        // Initialize the display field
        display = new JTextField();
        display.setBounds(50, 25, 300, 50);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));

        // Initialize function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        // Set font and add action listeners
        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }

        // Initialize number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
        }

        // Initialize the panel to hold buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add components to the frame
        this.add(panel);
        this.add(delButton);
        this.add(clrButton);
        this.add(display);

        delButton.setBounds(50, 420, 145, 50);
        clrButton.setBounds(205, 420, 145, 50);

        // Make the frame visible
        this.setVisible(true);
    }
}

@Override
public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < 10; i++) {
        if (e.getSource() == numberButtons[i]) {
            display.setText(display.getText().concat(String.valueOf(i)));
        }
    }
    if (e.getSource() == decButton) {
        if (!display.getText().contains(".")) {
            display.setText(display.getText().concat("."));
        }
    }
    if (e.getSource() == addButton) {
        num1 = Double.parseDouble(display.getText());
        operator = '+';
        display.setText("");
    }
    if (e.getSource() == subButton) {
        num1 = Double.parseDouble(display.getText());
        operator = '-';
        display.setText("");
    }
    if (e.getSource() == mulButton) {
        num1 = Double.parseDouble(display.getText());
        operator = '*';
        display.setText("");
    }
    if (e.getSource() == divButton) {
        num1 = Double.parseDouble(display.getText());
        operator = '/';
        display.setText("");
    }
    if (e.getSource() == equButton) {
        num2 = Double.parseDouble(display.getText());

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0)
                    result = num1 / num2;
                else {
                    display.setText("Error");
                    return;
                }
                break;
            default:
                result = 0;
        }
        display.setText(String.valueOf(result));
        num1 = result;
    }
    if (e.getSource() == clrButton) {
        display.setText("");
    }
    if (e.getSource() == delButton) {
        String str = display.getText();
        if (str.length() > 0) {
            display.setText(str.substring(0, str.length() - 1));
        }
    }
}
