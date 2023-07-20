package com.oxcentra.quotationmaker.service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;


@Slf4j
@Service
public class PdfGeneratorServiceImpl implements PdfGeneratorService{
    @Override
    public byte[] htmlToPdf(String finalHtml) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            PdfWriter pdfwriter = new PdfWriter(byteArrayOutputStream);
            DefaultFontProvider defaultFont = new DefaultFontProvider(false, true, false);
            ConverterProperties converterProperties = new ConverterProperties();
            converterProperties.setFontProvider(defaultFont);

            HtmlConverter.convertToPdf(finalHtml, pdfwriter, converterProperties);

            byte[] pdfBytes = byteArrayOutputStream.toByteArray();
            //String base64String = Base64.getEncoder().encodeToString(pdfBytes);

            log.info("pdf "+pdfBytes);

            return pdfBytes;

        } catch (Exception ex) {
            log.error("Error converting HTML to PDF: {}", ex.getMessage());
            // handle the exception or return an error message to the frontend
            return null;
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                log.error("Error closing ByteArrayOutputStream: {}", e.getMessage());
            }
        }

    }

    @Override
    public byte[] combinePdfFiles(List<byte[]> pdfs)throws IOException, DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();

        PdfCopy copy = new PdfCopy(document, outputStream);
        document.open();

        for (byte[] pdf : pdfs) {
            PdfReader reader = new PdfReader(pdf);
            int numPages = reader.getNumberOfPages();
            for (int i = 0; i < numPages; i++) {
                copy.addPage(copy.getImportedPage(reader, i + 1));
            }
            reader.close();
        }

        document.close();

        return outputStream.toByteArray();
    }
}
