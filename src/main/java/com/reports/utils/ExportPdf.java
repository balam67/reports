package com.reports.utils;

import com.lowagie.text.pdf.PdfPTable;
import com.reports.entity.CitizenPlanEntity;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
@Component
public class ExportPdf {

	private List<CitizenPlanEntity> citizenPlanEntityList;
	
	public void setCitizenPlanEntity(List<CitizenPlanEntity> citizenPlanEntityList) {
		this.citizenPlanEntityList = citizenPlanEntityList;
		
	}
	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("CITIZEN ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("PLAN NAME", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("PLAN STATUS", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("GENDER", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("CITIZEN NAME", font));
        table.addCell(cell);       
    }
     
    private void writeTableData(PdfPTable table) {
        for (CitizenPlanEntity citizenPlanEntity : citizenPlanEntityList) {
            table.addCell(String.valueOf(citizenPlanEntity.getCitizenId()));
            table.addCell(citizenPlanEntity.getPlanName());
            table.addCell(citizenPlanEntity.getPlanStatus());
            table.addCell(citizenPlanEntity.getGender());
            table.addCell(citizenPlanEntity.getCitizenName());
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("CITIZEN PLAN DETAILS", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
