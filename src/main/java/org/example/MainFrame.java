package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {
    private final PDFViewer pdfViewer;

    public MainFrame() {

        super("Leitor de PDF - By SilencioPZ");

        System.setProperty("sun.jnu.encoding", "UTF-8");
        System.setProperty("file.encoding", "UTF-8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        pdfViewer = new PDFViewer();
        JButton openButton = new JButton("Abrir PDF");
        JButton clearButton = new JButton("Limpar");

        openButton.addActionListener(e -> {
            try {
                openPDF();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        clearButton.addActionListener(e -> pdfViewer.clearText());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(clearButton);

        mainPanel.add(new JLabel("Visualizador de PDF", JLabel.CENTER), BorderLayout.NORTH);
        mainPanel.add(pdfViewer, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        adicionarLogo();
        add(mainPanel);
    }

    private void openPDF() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".pdf") || f.isDirectory();
            }
            public String getDescription() {
                return "Arquivos PDF (*.pdf)";
            }
        });

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                pdfViewer.loadPDF(selectedFile);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao ler o arquivo PDF:\n" + ex.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void adicionarLogo() {

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/silenciopz-logo-150.png"));
        if (logoIcon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar a logo.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setHorizontalAlignment(JLabel.CENTER);

        getContentPane().add(logoLabel, BorderLayout.NORTH);
    }
}