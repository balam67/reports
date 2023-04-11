package com.reports.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.reports.entity.CitizenPlanEntity;
import com.reports.form.SearchForm;
import com.reports.repository.CitizenPlanRepository;
import com.reports.utils.ExportPdf;

@Service
public class CitizenPlanServiceImpl implements CitizenPlanService {
	
	@Autowired
	private CitizenPlanRepository repo;
	

	@Override
	public List<String> getPlanNames() {


		List<String> planNamesList = repo.getPlanNames();
		return planNamesList;
	}

	@Override
	public List<String> getPlanStatuses() {
		List<String> planStatusesList = repo.getPlanStatuses();
		return planStatusesList;
	}

	@Override
	public List<CitizenPlanEntity> convertPdf() {
		List<CitizenPlanEntity> findAllPdfList = repo.findAll();
		
		return findAllPdfList;
	}

	@Override
	public List<CitizenPlanEntity> convertExcel() {
		
		List<CitizenPlanEntity> findAllPdfList = repo.findAll();
		return findAllPdfList;
	}

	@Override
	public List<CitizenPlanEntity> search(SearchForm searchForm) {
		
	
		CitizenPlanEntity citizenPlanEntity=new CitizenPlanEntity();
		
		//BeanUtils.copyProperties(searchRequest, entity);
		
		if(searchForm.getPlanName() != null && searchForm.getPlanName() != "") {
			citizenPlanEntity.setPlanName(searchForm.getPlanName());
		}
		
		if(searchForm.getPlanStatus() != null && searchForm.getPlanStatus() != "") {
			citizenPlanEntity.setPlanStatus(searchForm.getPlanStatus());
		}
		
		if(searchForm.getGender() != null && searchForm.getGender() != "") {
			citizenPlanEntity.setGender(searchForm.getGender());
		}
		
		if(searchForm.getPlanStartDate() != null ) {
			LocalDate planStartDate = searchForm.getPlanStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	       // LocalDate localDate = LocalDate.parse(planStartDate, formatter);
	        citizenPlanEntity.setPlanStartDate(planStartDate);	
		}
		
		if(searchForm.getPlanEndDate() != null) {
			LocalDate planEndDate = searchForm.getPlanEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        //LocalDate localDate = LocalDate.parse(planEndDate, formatter);
	        citizenPlanEntity.setPlanEndDate(planEndDate);
		}
		
		
		
		List<CitizenPlanEntity> findAllSearchList = repo.findAll(Example.of(citizenPlanEntity));
		return findAllSearchList;
	}

	
}
