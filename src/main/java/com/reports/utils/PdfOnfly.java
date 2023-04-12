package com.reports.utils;

import java.io.ByteArrayInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import com.lowagie.text.pdf.PdfPTable;
import java.io.ByteArrayOutputStream;
import com.reports.entity.CitizenPlanEntity;



import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

@Component
public class PdfOnfly {
	
	
	 public static ByteArrayInputStream citiesReport(List<CitizenPlanEntity> citizenPlanEntitiesList) {

	        Document document = new Document();
	        ByteArrayOutputStream out = new ByteArrayOutputStream();

	        try {

	            PdfPTable table = new PdfPTable(3);
	            table.setWidthPercentage(60);
	            table.setWidths(new int[]{1, 3, 3});

	            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

	            PdfPCell hcell;
	            hcell = new PdfPCell(new Phrase("Id", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("Name", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            hcell = new PdfPCell(new Phrase("Population", headFont));
	            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            table.addCell(hcell);

	            for (CitizenPlanEntity citizenPlanEntity : citizenPlanEntitiesList) {

	                PdfPCell cell;

	                cell = new PdfPCell(new Phrase(citizenPlanEntity.getCitizenId().toString()));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cell);

	                cell = new PdfPCell(new Phrase(citizenPlanEntity.getPlanName()));
	                cell.setPaddingLeft(5);
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	                table.addCell(cell);

	                cell = new PdfPCell(new Phrase(String.valueOf(citizenPlanEntity.getBenifitAmount())));
	                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	                cell.setPaddingRight(5);
	                table.addCell(cell);
	            }

	            PdfWriter.getInstance(document, out);
	            document.open();
	            document.add(table);

	            document.close();

	        } catch (DocumentException ex) {

	          
	        }

	        return new ByteArrayInputStream(out.toByteArray());
	    }
}
