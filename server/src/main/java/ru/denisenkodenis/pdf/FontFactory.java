package ru.denisenkodenis.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;

import java.awt.*;
import java.io.IOException;

public class FontFactory {
    private BaseFont baseFont;

    public FontFactory() throws IOException, DocumentException {
        baseFont = BaseFont.createFont("Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    }

    public Font get(int size){
        return new Font(baseFont, size);
    }

    public Font getBold(int size){
        return new Font(baseFont, size, Font.BOLD);
    }

    public Font getCustom(int size, int style, Color color){
        return new Font(baseFont, size, style, color);
    }
}