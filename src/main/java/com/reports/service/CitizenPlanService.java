package com.reports.service;

import java.util.List;

import com.reports.entity.CitizenPlanEntity;
import com.reports.form.SearchForm;

public interface CitizenPlanService {

	public List<String> getPlanNames();
	public List<String> getPlanStatuses();
	public List<CitizenPlanEntity> convertPdf();
	public List<CitizenPlanEntity> convertExcel();
	public List<CitizenPlanEntity> search(SearchForm searchForm);
	
		
	
}
