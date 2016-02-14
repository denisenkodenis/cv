package ru.denisenkodenis.view;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import ru.denisenkodenis.pdf.PdfGenerator;
import ru.denisenkodenis.service.DataService;

public class PdfView extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> map,
                                    Document document,
                                    PdfWriter pdfWriter,
                                    HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws Exception {
        DataService dataService = (DataService)map.get("Data");
        PdfGenerator pdfGenerator = new PdfGenerator();
        pdfGenerator.BuildDocument(document, dataService);
    }
}