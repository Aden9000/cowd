package CalcDiary;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CalculatorGUI3 {
    public static void showCalculatorFrame(boolean pincrt) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);

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
        display.setFont(new Font("Arial", Font.BOLD, 60));
        display.setBorder(BorderFactory.createEmptyBorder());
        return display;
    }

    private static JPanel createButtonPanel(JTextField display, JFrame frame, boolean pincrt) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        final String[] currentOperation = { "" };
        final double[] firstNumber = { 0 };
        final boolean[] isOperatorClicked = { false };
        String[] pin = {""};

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            buttonPanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    boolean createpin = pincrt;
                    
                    switch (command) {
                        case "C":
                            display.setText("");
                            currentOperation[0] = "";
                            firstNumber[0] = 0;
                            isOperatorClicked[0] = false;
                            break;
                        case "=":
                            if (createpin){
                                pin[0] = firstNumber[0]+currentOperation[0]+display.getText();
                                String storepin = String.join("",pin);

                                clearPIN();
                                try (BufferedWriter writer = new BufferedWriter(new FileWriter("PIN.txt", true))) {
                                    writer.write(storepin);
                                } catch (IOException j) {
                                    System.err.println("Error writing to the file: " + j.getMessage());
                                }
                                JOptionPane.showMessageDialog(frame,  storepin + " PIN Created Successfully!");
                                createpin= false;
                            }

                            pin[0] = firstNumber[0]+currentOperation[0]+display.getText();
                            String comparepin = String.join("",pin);
                                try (BufferedReader reader = new BufferedReader(new FileReader("PIN.txt"))) {
                                    String line;
                                    if (((line = reader.readLine()) != null))  {
                                        if(line.equals(comparepin)){
                                            frame.dispose();
                                            DiaryGUI2.showDiary();
                                        }
                                    }
                                } catch (IOException j) {
                                    System.err.println("Error reading the file: " + j.getMessage());
                                }
                            
                            if (!currentOperation[0].isEmpty() && !display.getText().isEmpty()) {
                                double secondNumber = Double.parseDouble(display.getText());
                                double result = 0;
                               
                                switch (currentOperation[0]) {
                                    case "+":
                                        result = firstNumber[0] + secondNumber;
                                        break;
                                    case "-":
                                        result = firstNumber[0] - secondNumber;
                                        break;
                                    case "*":
                                        result = firstNumber[0] * secondNumber;
                                        break;
                                    case "/":
                                        if (secondNumber != 0) {
                                            result = firstNumber[0] / secondNumber;
                                        } else {
                                            JOptionPane.showMessageDialog(frame, "Cannot divide by zero!", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                        break;
                                }
                                display.setText(String.valueOf(result));
                                currentOperation[0] = "";
                                isOperatorClicked[0] = false;
                            }
                            break;
                        case "+":
                        case "-":
                        case "*":
                        case "/":
                            if (!display.getText().isEmpty()) {
                                firstNumber[0] = Double.parseDouble(display.getText());
                                currentOperation[0] = command;
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

        JButton newFrameButton = new JButton("Calculator");
        newFrameButton.setFont(new Font("Arial", Font.BOLD, 16));
        newFrameButton.setBorderPainted(false);
        newFrameButton.setContentAreaFilled(false);
        newFrameButton.setFocusPainted(false);
        newFrameButton.setOpaque(false);

        newFrameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                showNewFrame();
            }
        });

        topPanel.add(newFrameButton, BorderLayout.NORTH);
        return topPanel;
    }

    private static void showNewFrame() {
        JFrame newFrame = new JFrame(" ");
        newFrame.setSize(400, 600);
        newFrame.setLocationRelativeTo(null);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());

        JButton backbutton = new JButton("Back");
        backbutton.setSize(60, 30);
        backbutton.setFont(new Font("Arial", Font.BOLD, 11));
        backbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                newFrame.dispose();
                showCalculatorFrame(false);
            }
        });

        String crt_rst = "";

            if (!isEmptyPIN())  
                crt_rst = "Reset";
            else
                crt_rst = "Create";

        JButton pinbutton = new JButton(crt_rst+ " PIN");

        pinbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFrame.dispose();
                showCalculatorFrame(true);
                JOptionPane.showMessageDialog(newFrame, "Creating a PIN:\n\nStep 1. Type anything on the calculator \n     to serve as your PIN.\n\nStep 2. Press \"=\" to confirm your PIN.");

            }
        });

        panel.add(pinbutton);

        newFrame.add(backbutton);
        newFrame.add(panel);
        newFrame.setVisible(true);
    }

    public static boolean isEmptyPIN(){
        try (BufferedReader reader = new BufferedReader(new FileReader("PIN.txt"))) {
            String line  = reader.readLine();
            if (line != null)  
                return false;
        } catch (IOException j) {
            System.err.println("Error reading the file: " + j.getMessage());
        }
        return true;
    }

    public static boolean clearPIN(){
        if(!isEmptyPIN()){
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
    //Main
    //****************************************************************************************************************************************************************************************
    public static void main(String[] args) {
        showCalculatorFrame(false);
    }
}
