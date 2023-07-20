package com.oxcentra.quotationmaker.service;

import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.List;

public interface PdfGeneratorService {
    byte[] htmlToPdf(String finalHtml);

    byte[] combinePdfFiles(List<byte[]> pdfs) throws IOException, DocumentException;
}
