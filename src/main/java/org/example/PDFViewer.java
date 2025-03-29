package org.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.function.Function;

public class PDFViewer extends JPanel {

    private final JTextArea textArea;
    private final JScrollPane scrollPane;
    private JLabel statusLabel;

    public PDFViewer() {
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setEditable(false);
        textArea.setFont(new Font("Serif", Font.PLAIN, 25));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(15, 25, 15, 25));

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        statusLabel = new JLabel("Pronto", SwingConstants.CENTER);
        statusLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        add(scrollPane, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }

    public void loadPDF(File file) throws IOException {

        if (file == null) {
            throw new FileNotFoundException("Arquivo não pode ser nulo");
        }

        if (!file.exists()) {
            throw new FileNotFoundException("Arquivo não encontrado: " + file.getPath());
        }

        try (PDDocument document = PDDocument.load(file)) {
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            stripper.setLineSeparator("\n");

            String rawText = stripper.getText(document);
            String formattedText = formatExtractedText(rawText);

            textArea.setText(formattedText);
            statusLabel.setText("Arquivo carregado: " + file.getName());

            System.out.println("Número de páginas: " + document.getNumberOfPages());
            System.out.println("Fontes usadas: " + document.getPage(0).getResources().getFontNames());
        }
    }

    private String formatExtractedText(String rawText) {
        // 1. Normalização básica do texto
        String formatted = rawText
                .replace("ﬁ", "fi")
                .replace("ﬂ", "fl")
                .replaceAll("\\s+", " ")
                .trim();

        // 2. Formatação de parágrafos (ABNT NBR 14724)
        formatted = formatted
                .replaceAll("(?<=\\n)(\\S)", "\t$1")
                .replaceAll("\\.\\s*(?=\\p{Lu})", ".\n\n")
                .replaceAll("(?<=\\n\\t)\".+?\"(?=\\n)",
                        new Function<String, String>() {
                            public String apply(String match) {
                                return match.replace("\n", " ");
                            }
                        }.toString())
                .replaceAll("\\s+([.,;:!?])", "$1");

        // 3. Formatação de elementos específicos (versão corrigida)
        formatted = formatted
                .replaceAll("(?i)(refer[eê]ncias|bibliografia)", "\n$1\n")
                .replaceAll("(?s)(\"{3}.+?\"{3})",
                        new Function<String, String>() {
                            public String apply(String match) {
                                return "\n    " + match.replace("\n", "\n    ");
                            }
                        }.toString());

        // 4. Ajustes finais
        return formatted
                .replaceAll("(\\n\\s*){3,}", "\n\n")
                .trim();
    }

    public void clearText() {
        textArea.setText("");
        statusLabel.setText("Pronto");
    }
}