package com.reports.controller;

import java.io.IOException;
import java.util.List;
import com.reports.utils.ExportExcel;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.lowagie.text.DocumentException;
import com.reports.entity.CitizenPlanEntity;
import com.reports.form.SearchForm;
import com.reports.service.CitizenPlanService;
import com.reports.utils.ExportPdf;
import java.util.Date;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class CitizenPlanController {
	
	@Autowired
	private CitizenPlanService citizenPlanService;
	
	@Autowired
	private ExportPdf exportPdf;
	
	@GetMapping("/")
	public String indexPage(Model model) {
		
		model.addAttribute("searchForm", new SearchForm());

		formInitBinding(model);
		
		return "index";
	}

	private void formInitBinding(Model model) {

		List<String> planNamesList = citizenPlanService.getPlanNames();
		List<String> planStatusesList = citizenPlanService.getPlanStatuses();
		
		model.addAttribute("planNamesList", planNamesList);
		model.addAttribute("planStatusesList", planStatusesList);
	}
	
	@PostMapping("/search")
	public String search(@ModelAttribute("searchForm") SearchForm searchForm, Model model) {
		
	
	    List<CitizenPlanEntity> searchList = citizenPlanService.search(searchForm);
		model.addAttribute("searchList", searchList);
		
		formInitBinding(model);
		
		
		model.addAttribute("msg", "Data successfully saved...");
		
		return "index";
	}
	
	@GetMapping("/pdf")
	public void exportToPdf(HttpServletResponse response) throws DocumentException, IOException{
		
		 response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	        
	        List<CitizenPlanEntity> convertPdfList = citizenPlanService.convertPdf();
	         
	        exportPdf.setCitizenPlanEntity(convertPdfList);
	         
	        
	        exportPdf.export(response);
	         
	    }
	
	
	@GetMapping("/excel")
	public void exportIntoExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=records_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<CitizenPlanEntity> convertExcelList = citizenPlanService.convertExcel();
		
		ExportExcel exportExcel = new ExportExcel(convertExcelList);

		exportExcel.generate(response);
	}
		
}



