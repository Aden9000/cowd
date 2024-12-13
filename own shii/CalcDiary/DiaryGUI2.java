package CalcDiary;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class DiaryGUI2 {

    public static void showDiary() {
        JFrame frame = new JFrame("Diary");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JButton backbutton = new JButton("Back");
        backbutton.setSize(60, 30);
        backbutton.setFont(new Font("Arial", Font.BOLD, 11));
        backbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                CalculatorGUI3.showCalculatorFrame(false);
            }
        });

        JPanel diaryPanel = createDiaryPanel(frame);
        frame.add(backbutton);
        frame.add(diaryPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static JPanel createDiaryPanel(JFrame frame) {
        JPanel diaryPanel = new JPanel();
        diaryPanel.setLayout(new GridBagLayout());

        JButton addEntryButton = createAddEntryButton(frame);

        diaryPanel.add(addEntryButton);

        return diaryPanel;
    }

    public static JButton createAddEntryButton(JFrame frame) {
        JButton addEntryButton = new JButton();
        addEntryButton.setPreferredSize(new Dimension(150, 150));
        addEntryButton.setLayout(new BorderLayout());

        JLabel plusLabel = new JLabel("+", SwingConstants.CENTER);
        plusLabel.setFont(new Font("Arial", Font.BOLD, 40));
        plusLabel.setForeground(Color.GRAY);

        JLabel textLabel = new JLabel("add entry", SwingConstants.CENTER);
        textLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        textLabel.setForeground(Color.BLACK);

        addEntryButton.add(plusLabel, BorderLayout.CENTER);
        addEntryButton.add(textLabel, BorderLayout.SOUTH);

        addEntryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                createNewEntryFrame();
            }
        });

        return addEntryButton;
    }

    public static JFrame createNewEntryFrame() {
        JFrame entryFrame = new JFrame("New Entry");
        entryFrame.setSize(400, 600);
        entryFrame.setLayout(new BorderLayout());
        entryFrame.setLocationRelativeTo(null);
        
        JPanel entryPanel = createEntryPanel();
        
        JButton backbutton = new JButton("Back");
        backbutton.setSize(60, 30);
        backbutton.setFont(new Font("Arial", Font.BOLD, 11));
        backbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                entryFrame.dispose();
                showDiary();
            }
        });

        JButton saveButton = createSaveButton(entryFrame);
        JButton viewButton = createViewButton(entryFrame);

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));   
        buttonPanel.add(viewButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(backbutton);

        entryFrame.add(entryPanel, BorderLayout.CENTER);
        entryFrame.add(buttonPanel, BorderLayout.SOUTH);

        entryFrame.setVisible(true);
        return entryFrame;
    }

    private static JTextArea textArea;

    public static JPanel createEntryPanel() {
        JPanel entryPanel = new JPanel();
        entryPanel.setLayout(new BorderLayout());

        JTextField titleField = new JTextField("Untitled Entry");
        titleField.setFont(new Font("Arial", Font.BOLD, 16));

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        entryPanel.add(titleField, BorderLayout.NORTH);
        entryPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        return entryPanel;
    }

    public static JButton createSaveButton(JFrame entryFrame) {
        JButton saveButton = new JButton("Save");
        
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String title = ((JTextField)((JPanel)entryFrame.getContentPane().getComponent(0)).getComponent(0)).getText();
            String content = textArea.getText();

            String folderPath = "entries";
            
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdir();
            }
            
            String filename = folderPath + File.separator + title + ".txt";
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                writer.write("Title: " + title);
                writer.newLine();
                writer.write("Diary Entry:");
                writer.newLine();
                writer.write(content);
                writer.newLine();
                JOptionPane.showMessageDialog(entryFrame, "Entry saved to file: " + filename, "Saved", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(entryFrame, "Error saving entry: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        });
        return saveButton;
    }

    public static JButton createViewButton(JFrame entryFrame) {
        JButton viewButton = new JButton("View  Files");
        
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String folderPath = "entries";
                
                File folder = new File(folderPath);
                
                if (folder.exists() && folder.isDirectory()) {
                    File[] files = folder.listFiles();

                    if (files != null && files.length > 0) {
                        String[] fileNames = new String[files.length];
                        for (int i = 0; i < files.length; i++) {
                            fileNames[i] = files[i].getName();
                        }

                        JList<String> fileList = new JList<>(fileNames);

                        fileList.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() == 2) {
                                    String selectedFileName = fileList.getSelectedValue();
                                    File selectedFile = new File(folder, selectedFileName);

                                    if (selectedFile.isFile() && selectedFile.getName().endsWith(".txt")) {
                                        try {
                                            String content = new String(Files.readAllBytes(selectedFile.toPath()), StandardCharsets.UTF_8);
                                            
                                            JTextArea textArea = new JTextArea(content);
                                            textArea.setEditable(true);
                                            JScrollPane scrollPane = new JScrollPane(textArea);

                                            JButton saveButton = new JButton("Save Changes");
                                            saveButton.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {
                                                        String editedContent = textArea.getText();
                                                        Files.write(selectedFile.toPath(), editedContent.getBytes(StandardCharsets.UTF_8));

                                                        JOptionPane.showMessageDialog(entryFrame, "File saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                                    } catch (IOException ex) {
                                                        JOptionPane.showMessageDialog(entryFrame, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                }
                                            });

                                            JPanel panel = new JPanel();
                                            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                                            panel.add(scrollPane);
                                            panel.add(saveButton);
                                            
                                            JOptionPane.showMessageDialog(entryFrame, panel, "Edit File - " + selectedFileName, JOptionPane.PLAIN_MESSAGE);
                                        } catch (IOException ex) {
                                            JOptionPane.showMessageDialog(entryFrame, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            Desktop.getDesktop().open(selectedFile);
                                        } catch (IOException ex) {
                                            JOptionPane.showMessageDialog(entryFrame, "Error opening file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }
                            }
                        });

                        JScrollPane scrollPane = new JScrollPane(fileList);

                        JOptionPane.showMessageDialog(entryFrame, scrollPane, "View Files", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(entryFrame, "No files found in the folder.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(entryFrame, "Folder does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return viewButton;
    }

}
