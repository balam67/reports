package com.reports.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.reports.entity.CitizenPlanEntity;

import org.springframework.core.io.FileSystemResource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import com.lowagie.text.pdf.PdfPTable;
import java.io.ByteArrayOutputStream;
import javax.mail.util.ByteArrayDataSource;


import com.lowagie.text.*;
import com.lowagie.text.pdf.*;


@Component
public class EmailSenderPdf {

	
	@Autowired
	private JavaMailSender emailSender;

	public void sendPdfToEmail(List<CitizenPlanEntity> convertPdfList) throws MessagingException, IOException {
	    // Create PDF
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    Document document = new Document();
	    PdfWriter.getInstance(document, baos);
	    document.open();
	    PdfPTable table = new PdfPTable(3);
	    table.addCell("ID");
	    table.addCell("Name");
	    table.addCell("Email");
	    for (CitizenPlanEntity CitizenPlanEntity : convertPdfList) {
	        table.addCell(String.valueOf(CitizenPlanEntity.getCitizenId()));
	        table.addCell(CitizenPlanEntity.getPlanName());
	        table.addCell(CitizenPlanEntity.getPlanStatus());
	    }
	    document.add(table);
	    document.close();

	    // Send email
	    MimeMessage message = emailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    helper.setTo("bala.m15432@gmail.com");
	    helper.setSubject("Your PDF");
	    helper.setText("Please find attached your PDF.");
	    ByteArrayDataSource dataSource = new ByteArrayDataSource(baos.toByteArray(), "application/pdf");
	    helper.addAttachment("your-pdf.pdf", dataSource);

	    emailSender.send(message);
	}
}
