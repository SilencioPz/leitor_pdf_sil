package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class PDFViewerTest {

    @Test
    void testLoadValidPDF() {
        PDFViewer viewer = new PDFViewer();
        File testFile = new File("src/test/resources/test_files/windows_xp.pdf");

        assertDoesNotThrow(() -> viewer.loadPDF(testFile));
    }

    @Test
    void testLoadInvalidFile() {
        PDFViewer viewer = new PDFViewer();
        File invalidFile = new File("caminho/inexistente.pdf");

        assertThrows(IOException.class, () -> viewer.loadPDF(invalidFile));
    }

    @Test
    void testLoadTextFileInsteadOfPDF() {
        PDFViewer viewer = new PDFViewer();
        File textFile = new File("src/test/resources/test_files/codigos_em_c.txt");

        if (!textFile.exists()) {
            try (FileWriter writer = new FileWriter(textFile)) {
                writer.write("Isso é um arquivo de texto, não um PDF");
            } catch (IOException e) {
                fail("Não foi possível criar o arquivo de teste");
            }
        }

        assertThrows(IOException.class, () -> viewer.loadPDF(textFile));
    }
}