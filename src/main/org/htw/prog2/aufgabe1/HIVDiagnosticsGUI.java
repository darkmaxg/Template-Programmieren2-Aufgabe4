package org.htw.prog2.aufgabe1;

import javax.swing.*;
import java.awt.*;

public class HIVDiagnosticsGUI extends JFrame {

    public HIVDiagnosticsGUI() {
        setTitle("HIV Diagnostics Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(createMenuBar());
        JPanel filePanel = new JPanel(new GridLayout(3, 1));
        filePanel.add(createFileRow("Please load a mutation CSV file"));
        filePanel.add(createFileRow("Please load a reference FASTA/FASTQ file"));
        filePanel.add(createFileRow("Please load a patient FASTA/FASTQ file"));
        JPanel predictPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton predictButton = new JButton("Predict best drug");
        predictButton.setEnabled(false); // Button ausgegraut, später diese Zeile entfernen
        predictPanel.add(predictButton);
        add(filePanel, BorderLayout.CENTER);
        add(predictPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem aboutItem = new JMenuItem("About");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(aboutItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        return menuBar;
    }

    private JPanel createFileRow(String labelText) {
        JPanel row = new JPanel(new BorderLayout());
        JLabel label = new JLabel(labelText);
        ImageIcon folderIcon = new ImageIcon("resources/folder_explore.png");
        JButton browseButton = new JButton(folderIcon);
        row.add(label, BorderLayout.WEST);
        row.add(browseButton, BorderLayout.EAST);
        return row;
    }
}