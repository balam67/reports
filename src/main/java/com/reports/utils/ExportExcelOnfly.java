package com.reports.utils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.reports.entity.CitizenPlanEntity;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
public class ExportExcelOnfly {

	public void writeListToExcel( List<CitizenPlanEntity> citizenPlanEntityList) throws IOException {
	    Workbook workbook = new XSSFWorkbook();
	Sheet createSheet = workbook.createSheet("Sheet 1");

	    int rowNum = 0;
	    for (CitizenPlanEntity citizenPlanEntity : citizenPlanEntityList) {
	        Row row = createSheet.createRow(rowNum++);
	        row.createCell(0).setCellValue(citizenPlanEntity.getField1());
	        row.createCell(1).setCellValue(citizenPlanEntity.getField2());
	        row.createCell(2).setCellValue(citizenPlanEntity.getField3());
	    }

	    FileOutputStream outputStream = new FileOutputStream("data.xlsx");
	    workbook.write(outputStream);
	    workbook.close();
	}
}
