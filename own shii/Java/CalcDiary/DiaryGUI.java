import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DiaryGUI {
    private static JTextArea textArea;
    private static JFrame editframe;

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
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                CalculatorGUI.showCalculatorFrame(false);
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
        JButton viewButton = createViewButton(frame);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        diaryPanel.add(addEntryButton, gbc);

        gbc.gridy = 1;
        diaryPanel.add(viewButton, gbc);

        return diaryPanel;
    }

    public static JFrame createNewEntryFrame() {
        JFrame entryFrame = new JFrame("New Entry");
        entryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        entryFrame.setSize(400, 600);
        entryFrame.setLayout(new BorderLayout());
        entryFrame.setLocationRelativeTo(null);

        JPanel entryPanel = createEntryPanel();

        JButton backbutton = new JButton("Back");
        backbutton.setSize(60, 30);
        backbutton.setFont(new Font("Arial", Font.BOLD, 11));
        backbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                entryFrame.dispose();
                showDiary();
            }
        });

        JButton saveButton = createSaveButton(entryFrame);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(saveButton);
        buttonPanel.add(backbutton);

        entryFrame.add(entryPanel, BorderLayout.CENTER);
        entryFrame.add(buttonPanel, BorderLayout.SOUTH);

        entryFrame.setVisible(true);
        return entryFrame;
    }

    public static JPanel createEntryPanel() {
        JPanel entryPanel = new JPanel();
        entryPanel.setLayout(new BorderLayout());

        JTextField titleField = new JTextField("Untitled Entry");
        titleField.setFont(new Font("Arial", Font.BOLD, 16));

        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        entryPanel.add(titleField, BorderLayout.NORTH);
        entryPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        return entryPanel;
    }

    public static JButton createAddEntryButton(JFrame frame) {
        JButton addEntryButton = new JButton();
        addEntryButton.setPreferredSize(new Dimension(150, 150));
        addEntryButton.setLayout(new BorderLayout());

        JLabel plusLabel = new JLabel("+", SwingConstants.CENTER);
        plusLabel.setFont(new Font("Arial", Font.BOLD, 40));
        plusLabel.setForeground(Color.GRAY);

        JLabel textLabel = new JLabel("Add Entry", SwingConstants.CENTER);
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

    public static JButton createSaveButton(JFrame entryFrame) {
        JButton saveButton = new JButton("Save");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = ((JTextField) ((JPanel) entryFrame.getContentPane().getComponent(0)).getComponent(0))
                        .getText();
                String content = textArea.getText();
                String filename = "";
                String folderPath = "entries";

                File folder = new File(folderPath);
                if (!folder.exists()) {
                    folder.mkdir();
                }

                if (title.trim().equals("")) {
                    title = "Untitled Entry";
                }

                filename = folderPath + File.separator + title + ".txt";

                File file = new File(filename);

                if (file.exists()) {
                    JOptionPane.showMessageDialog(entryFrame,
                            "Error saving entry: " + filename + " file already exists", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("E/MM/dd/yyyy");
                    String formatedate = dateFormat.format(date);
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                        writer.write("Date: " + formatedate);
                        writer.newLine();
                        writer.newLine();
                        writer.write("Diary Entry:");
                        writer.newLine();
                        writer.newLine();
                        writer.write(content);
                        writer.newLine();
                        JOptionPane.showMessageDialog(entryFrame, "Entry saved to file: " + filename, "Saved",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(entryFrame, "Error saving entry: " + ex.getMessage(), "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        return saveButton;
    }

    public static JButton createViewButton(JFrame entryFrame) {
        JButton viewButton = new JButton("View Entries");
        viewButton.setPreferredSize(new Dimension(150, 30));

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame viewfilesframe = new JFrame("View Entries");
                viewfilesframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                viewfilesframe.setSize(250, 150);
                viewfilesframe.setLocationRelativeTo(null);

                String folderPath = "entries";

                File folder = new File(folderPath);

                if (folder.exists() && folder.isDirectory()) {

                    File[] files = folder.listFiles();

                    if (files != null && files.length > 0) {
                        entryFrame.dispose();
                        String[] fileNames = new String[files.length];
                        for (int i = 0; i < files.length; i++) {
                            fileNames[i] = files[i].getName();
                        }

                        JList<String> fileList = new JList<>(fileNames);
                        editframe = null;

                        fileList.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (e.getClickCount() == 2) {
                                    String selectedFileName = fileList.getSelectedValue();
                                    File selectedFile = new File(folder, selectedFileName);

                                    if (selectedFile.isFile() && selectedFile.getName().endsWith(".txt")) {

                                        try {
                                            String content = new String(Files.readAllBytes(selectedFile.toPath()),
                                                    StandardCharsets.UTF_8);

                                            if (editframe != null) {
                                                editframe.dispose();
                                            }

                                            editframe = new JFrame("Edit Entry - " + selectedFileName);
                                            editframe.setSize(400, 600);
                                            editframe.setLayout(new BorderLayout());
                                            editframe.setLocationRelativeTo(null);

                                            JTextArea textArea = new JTextArea(content);
                                            textArea.setFont(new Font("Arial", Font.PLAIN, 16));
                                            textArea.setEditable(true);
                                            JScrollPane scrollPane = new JScrollPane(textArea);

                                            JButton saveButton = new JButton("Save Changes");
                                            saveButton.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    try {
                                                        String editedContent = textArea.getText();
                                                        Files.write(selectedFile.toPath(),
                                                                editedContent.getBytes(StandardCharsets.UTF_8));

                                                        JOptionPane.showMessageDialog(editframe,
                                                                "Entry saved successfully.", "Success",
                                                                JOptionPane.INFORMATION_MESSAGE);
                                                    } catch (IOException ex) {
                                                        JOptionPane.showMessageDialog(editframe,
                                                                "Error saving file: " + ex.getMessage(), "Error",
                                                                JOptionPane.ERROR_MESSAGE);
                                                    }
                                                }
                                            });

                                            JButton backbutton = new JButton("Back");
                                            backbutton.setSize(60, 30);
                                            backbutton.setFont(new Font("Arial", Font.BOLD, 11));
                                            backbutton.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    editframe.dispose();
                                                    showDiary();
                                                }
                                            });

                                            JButton deleteButton = new JButton("Delete Entry");
                                            deleteButton.setFont(new Font("Arial", Font.BOLD, 11));
                                            deleteButton.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                    int confirmDelete = JOptionPane.showConfirmDialog(editframe,
                                                            "Are you sure you want to delete this entry?",
                                                            "Delete Entry", JOptionPane.YES_NO_OPTION);
                                                    if (confirmDelete == JOptionPane.YES_OPTION) {
                                                        try {
                                                            boolean deleted = selectedFile.delete();
                                                            if (deleted) {
                                                                JOptionPane.showMessageDialog(editframe,
                                                                        "Entry deleted successfully.", "Success",
                                                                        JOptionPane.INFORMATION_MESSAGE);
                                                                editframe.dispose();
                                                                showDiary();
                                                            } else {
                                                                JOptionPane.showMessageDialog(editframe,
                                                                        "Error deleting file.", "Error",
                                                                        JOptionPane.ERROR_MESSAGE);
                                                            }
                                                        } catch (SecurityException ex) {
                                                            JOptionPane.showMessageDialog(editframe,
                                                                    "Permission denied: " + ex.getMessage(), "Error",
                                                                    JOptionPane.ERROR_MESSAGE);
                                                        }
                                                    }
                                                }
                                            });

                                            JPanel editpanel = new JPanel();
                                            editpanel.setLayout(new BoxLayout(editpanel, BoxLayout.Y_AXIS));
                                            editpanel.add(scrollPane);

                                            JPanel buttonpanel = new JPanel();
                                            buttonpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                                            buttonpanel.add(saveButton);
                                            buttonpanel.add(backbutton);
                                            buttonpanel.add(deleteButton);

                                            editframe.add(editpanel, BorderLayout.CENTER);
                                            editframe.add(buttonpanel, BorderLayout.SOUTH);

                                            editframe.setVisible(true);

                                        } catch (IOException ex) {
                                            JOptionPane.showMessageDialog(entryFrame,
                                                    "Error reading file: " + ex.getMessage(), "Error",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    } else {
                                        try {
                                            Desktop.getDesktop().open(selectedFile);
                                        } catch (IOException ex) {
                                            JOptionPane.showMessageDialog(entryFrame,
                                                    "Error opening file: " + ex.getMessage(), "Error",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }
                            }
                        });

                        JScrollPane scrollPane = new JScrollPane(fileList);

                        JButton backbutton = new JButton("Back");
                        backbutton.setSize(60, 30);
                        backbutton.setFont(new Font("Arial", Font.BOLD, 11));

                        backbutton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                viewfilesframe.dispose();
                                showDiary();
                            }
                        });

                        viewfilesframe.add(scrollPane, BorderLayout.CENTER);
                        viewfilesframe.add(backbutton, BorderLayout.SOUTH);

                        viewfilesframe.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(entryFrame, "No files found in the folder/No Entries yet.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(entryFrame, "Folder does not exist/No Entries yet.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        return viewButton;
    }

}
