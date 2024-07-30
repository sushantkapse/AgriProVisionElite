package com.example.agriprovisionelite.testing;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.core.content.FileProvider;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class PdfGenerator {

    public static void generatePdf(Context context, String fileName, String farmerDetails) throws IOException {
        File pdfFile = new File(context.getExternalFilesDir(null), fileName);
        if (!pdfFile.getParentFile().exists()) {
            pdfFile.getParentFile().mkdirs(); // Create directories if they don't exist
        }

        PdfWriter writer = new PdfWriter(new FileOutputStream(pdfFile));
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        // Add content to the PDF
        document.add(new Paragraph("Farmer Registration Details"));
        document.add(new Paragraph(farmerDetails)); // Add farmer details here

        document.close();

        // Share the PDF file using FileProvider
        Uri fileUri = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", pdfFile);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(fileUri, "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        context.startActivity(intent);
    }
}