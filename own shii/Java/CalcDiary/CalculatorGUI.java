import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.script.*;

public class CalculatorGUI {

    private static final ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
    private static final ImageIcon icon = new ImageIcon("CalcDiary.png");

    public static void showCalculatorFrame(boolean pincrt) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(icon.getImage());

        JTextField display = createDisplay();
        JPanel buttonPanel = createButtonPanel(display, frame, pincrt);
        JPanel topPanel = createTopPanel(display, frame);

        frame.setLayout(new BorderLayout());
        topPanel.add(display, BorderLayout.SOUTH);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static JTextField createDisplay() {
        JTextField display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 70));
        display.setBorder(null);
        return display;
    }

    private static JPanel createButtonPanel(JTextField display, JFrame frame, boolean pincrt) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        final StringBuilder currentOperation = new StringBuilder();
        final double[] firstNumber = { 0 };
        final boolean[] isOperatorClicked = { false };
        String[] pin = { "" };

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
                    boolean createpin = pincrt;

                    switch (command) {
                        case "C":
                            display.setText("");
                            currentOperation.setLength(0);
                            firstNumber[0] = 0;
                            isOperatorClicked[0] = false;
                            break;
                        case "=":
                            if (createpin) {
                                pin[0] = firstNumber[0] + currentOperation.toString() + display.getText();
                                String storepin = pin[0];

                                clearPIN();
                                try (BufferedWriter writer = new BufferedWriter(new FileWriter("PIN.txt", true))) {
                                    writer.write(storepin);
                                } catch (IOException j) {
                                    System.err.println("Error writing to the file: " + j.getMessage());
                                }
                                JOptionPane.showMessageDialog(frame, "PIN Created Successfully!");
                                createpin = false;
                            }

                            pin[0] = firstNumber[0] + currentOperation.toString() + display.getText();
                            String comparepin = pin[0];
                            try (BufferedReader reader = new BufferedReader(new FileReader("PIN.txt"))) {
                                String line;
                                if ((line = reader.readLine()) != null) {
                                    if (line.equals(comparepin)) {
                                        frame.dispose();
                                        DiaryGUI.showDiary();
                                    }
                                }
                            } catch (IOException j) {
                                System.err.println("Error reading the file: " + j.getMessage());
                            }

                            try {
                                Object result = engine.eval(currentOperation.toString() + display.getText());
                                if(result == null){
                                    display.setText("");
                                }else{
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

        return buttonPanel;
    }

    private static JPanel createTopPanel(JTextField display, JFrame frame) {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        JButton hiddencalc = new JButton("Calculator");
        hiddencalc.setFont(new Font("Arial", Font.BOLD, 16));
        hiddencalc.setBorderPainted(false);
        hiddencalc.setContentAreaFilled(false);
        hiddencalc.setFocusPainted(false);
        hiddencalc.setOpaque(false);

        hiddencalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showNewFrame();
            }
        });

        topPanel.add(hiddencalc, BorderLayout.WEST);
        return topPanel;
    }

    private static void showNewFrame() {
        JFrame newFrame = new JFrame(" ");
        newFrame.setSize(400, 600);
        newFrame.setLocationRelativeTo(null);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setIconImage(icon.getImage());
        
        JPanel panel = new JPanel(new GridBagLayout());

        JButton backbutton = new JButton("Back");
        backbutton.setSize(60, 30);
        backbutton.setFont(new Font("Arial", Font.BOLD, 11));
        backbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFrame.dispose();
                showCalculatorFrame(false);
            }
        });

        String crt_rst = "";

        if (!isEmptyPIN())
            crt_rst = "Reset";
        else
            crt_rst = "Create";

        JButton pinbutton = new JButton(crt_rst + " PIN");

        pinbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFrame.dispose();
                showCalculatorFrame(true);
                JOptionPane.showMessageDialog(newFrame,
                        "Creating a PIN:\n\nStep 1. Type anything on the calculator \n     to serve as your PIN.\n\nStep 2. Press \"=\" to confirm your PIN.");
            }
        });

        panel.add(pinbutton);

        newFrame.add(backbutton);
        newFrame.add(panel);
        newFrame.setVisible(true);
    }

    public static boolean isEmptyPIN() {
        try (BufferedReader reader = new BufferedReader(new FileReader("PIN.txt"))) {
            String line = reader.readLine();
            if (line != null)
                return false;
        } catch (IOException j) {
            System.err.println("Error reading the file: " + j.getMessage());
        }
        return true;
    }

    public static boolean clearPIN() {
        if (!isEmptyPIN()) {
            try {
                FileWriter writer = new FileWriter("PIN.txt", false);
                writer.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
