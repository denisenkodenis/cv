package ru.denisenkodenis.pdf;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.draw.LineSeparator;

import ru.denisenkodenis.model.*;
import ru.denisenkodenis.service.DataService;
import java.awt.*;
import java.io.IOException;

public class PdfGenerator {
    private FontFactory fontFactory;

    public PdfGenerator() throws IOException, DocumentException {
        fontFactory = new FontFactory();
    }

    public void BuildDocument(Document document, DataService dataService) throws Exception {
        buildHeader(document,dataService);
        buildSummary(document,dataService);
        buildSkills(document, dataService);
        buildJobs(document, dataService);
        buildEducations(document, dataService);
    }


    private void buildHeader(Document document, DataService dataService) throws Exception {
        PersonalInfo info = dataService.getPersonalInfo();
        document.add(new Paragraph(info.getName(), fontFactory.getBold(17)));

        PdfPTable table = new PdfPTable(2);
        PdfPCell birthday = createCell(info.getBirthDay(), fontFactory.get(12));
        birthday.setPaddingLeft(10);
        table.addCell(birthday);
        PdfPCell city = createCell(info.getCity(), fontFactory.get(12));
        city.setRightIndent(10);
        city.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(city);

        document.add(table);

        document.add(Chunk.NEWLINE);
        document.add(new LineSeparator());

        Paragraph contacts = new Paragraph();
        contacts.add(new Chunk("E-mail: ", fontFactory.getBold(10)));
        contacts.add(new Chunk(info.getMail(), fontFactory.getCustom(10, Font.UNDERLINE, Color.BLUE)));
        contacts.add(new Chunk("    Skype: ", fontFactory.getBold(10)));
        contacts.add(new Chunk(info.getSkype(), fontFactory.get(10)));
        contacts.add(new Chunk("    Phone: ", fontFactory.getBold(10)));
        contacts.add(new Chunk(info.getPhone(), fontFactory.get(10)));
        contacts.setAlignment(Element.ALIGN_CENTER);
        document.add(contacts);

        document.add(Chunk.NEWLINE);
        document.add(new LineSeparator());
        document.add(Chunk.NEWLINE);
    }

    private void buildSummary(Document document, DataService dataService) throws Exception {
        Paragraph summary = new Paragraph(dataService.getPersonalInfo().getDescription(), fontFactory.get(12));
        summary.setFirstLineIndent(20);
        summary.setIndentationLeft(50);
        summary.setIndentationRight(50);
        summary.setAlignment(Element.ALIGN_JUSTIFIED);
        document.add(summary);
        document.add(Chunk.NEWLINE);
        document.add(new LineSeparator());
    }

    private void buildSkills(Document document, DataService dataService) throws Exception {
        document.add(new Paragraph(dataService.getHeaders().getSkills(), fontFactory.getBold(12)));
        document.add(Chunk.NEWLINE);
        document.add(new LineSeparator());

        PdfPTable table = new PdfPTable(2);
        table.setWidths(new float[] {20, 80} );

        for(Skill skill : dataService.getSkills()){
            table.addCell(createCell(skill.getName(), fontFactory.getBold(12)));
            table.addCell(createCell(skill.getDescription(), fontFactory.get(12)));
        }

        document.add(table);
        document.add(Chunk.NEWLINE);
        document.add(new LineSeparator());
    }

    private void buildJobs(Document document, DataService dataService) throws Exception {
        Font font = fontFactory.get(12);
        Font boldFont = fontFactory.getBold(12);
        document.add(new Paragraph(dataService.getHeaders().getJobs(), boldFont));
        document.add(Chunk.NEWLINE);
        document.add(new LineSeparator());

        for(Job job: dataService.getJobs()){
            PdfPTable table = new PdfPTable(2);
            table.setWidths(new float[] {30, 70} );

            table.addCell(createCell(job.getDuration(), boldFont));
            table.addCell(createCell("", font));

            for(NamedProperty jobProp: job.getDescriptions()){
                table.addCell(createCell(jobProp.getName(), boldFont));
                table.addCell(createCell(jobProp.getDescription(), font));
            }

            document.add(table);

            document.add(Chunk.NEWLINE);
            document.add(new LineSeparator());
        }
    }

    private void buildEducations(Document document, DataService dataService) throws Exception {
        Font font = fontFactory.get(12);
        Font boldFont = fontFactory.getBold(12);
        document.add(new Paragraph(dataService.getHeaders().getEducation(), boldFont));
        document.add(Chunk.NEWLINE);
        document.add(new LineSeparator());

        for(Education education : dataService.getEducations()){
            document.add(new Paragraph(education.getTime(), boldFont));
            document.add(new Paragraph(education.getAcademy(), boldFont));
            document.add(new Paragraph(education.getDepartment(), font));
            document.add(new Paragraph(education.getDiploma(), font));
        }

        document.add(Chunk.NEWLINE);
        document.add(new LineSeparator());
    }


    private PdfPCell createCell(String text, Font font){
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }
}
