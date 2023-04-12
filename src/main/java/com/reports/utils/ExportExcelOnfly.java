package com.reports.utils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.reports.entity.CitizenPlanEntity;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;


@Component
public class ExportExcelOnfly {
	
	@Autowired
	private JavaMailSender emailSender;


	public void writeListToExcel( List<CitizenPlanEntity> citizenPlanEntityList) throws IOException, MessagingException {

		

		// Create an Excel file from the list of entities
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Entities");

		int rowNumber = 0;
		for (CitizenPlanEntity citizenPlanEntity : citizenPlanEntityList) {
		    Row row = sheet.createRow(rowNumber++);
		    row.createCell(0).setCellValue(citizenPlanEntity.getCitizenId());
		    row.createCell(1).setCellValue(citizenPlanEntity.getPlanName());
		}

		workbook.write(outputStream);

		// Convert the Excel file to a byte array
		byte[] bytes = outputStream.toByteArray();

		// Send an email with the byte array as an attachment
		MimeMessage message = emailSender.createMimeMessage();
		
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo("bala.m15432@gmail.com");
		helper.setSubject("Entities Report");
		helper.setText("Please find attached the report for entities.");
		helper.addAttachment("entities.xlsx", new ByteArrayResource(bytes));

		emailSender.send(message);
		
	}
}
