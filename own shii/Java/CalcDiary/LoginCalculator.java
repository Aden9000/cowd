
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LoginCalculator {
    private static final String FILE_NAME = "users.txt";
    private static final ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setBounds(500, 200, 350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setResizable(false);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 80, 100, 25);
        panel.add(registerButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(10, 110, 300, 25);
        panel.add(messageLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (validateLogin(username, password)) {
                    messageLabel.setText("Login successful!");

                    JFrame frame = new JFrame("Button Calculator");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setBounds(500, 100, 400, 600);

                    JTextField display = new JTextField();
                    display.setEditable(false);
                    display.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
                    display.setHorizontalAlignment(JTextField.RIGHT);
                    display.setFont(new Font("Arial", Font.BOLD, 70));

                    JPanel buttonPanel = new JPanel();
                    buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

                    final StringBuilder currentOperation = new StringBuilder();
                    final double[] firstNumber = { 0 };
                    final boolean[] isOperatorClicked = { false };

                    String[] buttons = {
                            "7", "8", "9", "/",
                            "4", "5", "6", "*",
                            "1", "2", "3", "-",
                            "C", "0", "=", "+"
                    };

                    for (String text : buttons) {
                        JButton button = new JButton(text);
                        button.setFont(new Font("Arial", Font.BOLD, 20));
                        buttonPanel.setBackground(Color.GRAY);
                        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
                        buttonPanel.add(button);

                        button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                String command = e.getActionCommand();

                                switch (command) {
                                    case "C":
                                        display.setText("");
                                        currentOperation.setLength(0);
                                        firstNumber[0] = 0;
                                        isOperatorClicked[0] = false;
                                        break;
                                    case "=":

                                        try {
                                            Object result = engine
                                                    .eval(currentOperation.toString() + display.getText());
                                            if (result == null) {
                                                display.setText("");
                                            } else {
                                                display.setText(String.valueOf(result));
                                            }
                                            currentOperation.setLength(0);
                                            isOperatorClicked[0] = false;
                                        } catch (ScriptException ex) {
                                            JOptionPane.showMessageDialog(frame, "Error in expression!", "Error",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                        break;
                                    case "+":
                                    case "-":
                                    case "*":
                                    case "/":
                                        if (!display.getText().isEmpty()) {
                                            firstNumber[0] = Double.parseDouble(display.getText());
                                            currentOperation.append(display.getText()).append(command);
                                            isOperatorClicked[0] = true;
                                            display.setText("");
                                        }
                                        break;
                                    default:
                                        if (isOperatorClicked[0]) {
                                            display.setText("");
                                            isOperatorClicked[0] = false;
                                        }
                                        display.setText(display.getText() + command);
                                        break;
                                }
                            }
                        });
                    }

                    frame.setLayout(new BorderLayout());
                    frame.add(display, BorderLayout.NORTH);
                    frame.add(buttonPanel, BorderLayout.CENTER);

                    frame.setVisible(true);
                } else {
                    messageLabel.setText("Invalid username or password.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (registerUser(username, password)) {
                    messageLabel.setText("User registered successfully!");
                } else {
                    messageLabel.setText("User already exists.");
                }
            }
        });
    }

    private static boolean validateLogin(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return false;
    }

    private static boolean registerUser(String username, String password) {

        if (validateLogin(username, password)) {
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(username + "," + password);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
        return true;
    }
}
