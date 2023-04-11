package com.reports.runner;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import com.reports.entity.CitizenPlanEntity;
import com.reports.repository.CitizenPlanRepository;

public class CitizenPlanRunner implements ApplicationRunner {

	@Autowired
	private CitizenPlanRepository repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		
		CitizenPlanEntity e1 = new CitizenPlanEntity("Ajay","Male","FOOD", "Approved",LocalDate.now(),LocalDate.now(),5000.0,null,null,null);
		CitizenPlanEntity e2 = new CitizenPlanEntity("Anitha","Fe-Male","FOOD", "Denaid",null,null,null,"job holder",null,null);
		CitizenPlanEntity e3 = new CitizenPlanEntity("Varun","Male","FOOD", "Terminated",LocalDate.now(),LocalDate.now(),5000.0,null,null,"got new job");
		
		
		CitizenPlanEntity e4 = new CitizenPlanEntity("Ishanth","Male","Medical", "Approved",LocalDate.now(),LocalDate.now(),5000.0,null,null,null);
		CitizenPlanEntity e5 = new CitizenPlanEntity("Madhuri","Fe-Male","Medical", "Denaid",null,null,null,"job holder",null,null);
		CitizenPlanEntity e6 = new CitizenPlanEntity("Karuna","Male","Medical", "Terminated",LocalDate.now(),LocalDate.now(),5000.0,null,LocalDate.now(),"got new job");
		
		
		CitizenPlanEntity e7 = new CitizenPlanEntity("James","Male","Cash", "Approved",LocalDate.now(),LocalDate.now(),5000.0,null,null,null);
		CitizenPlanEntity e8 = new CitizenPlanEntity("vanitha","Fe-Male","Cash", "Denaid",null,null,null,"job holder",null,null);
		CitizenPlanEntity e9 = new CitizenPlanEntity("Steve","Male","Cash", "Terminated",LocalDate.now(),LocalDate.now(),5000.0,null,LocalDate.now(),"got new job");
		
		
		CitizenPlanEntity e10 = new CitizenPlanEntity("Akash","Male","Employment", "Approved",LocalDate.now(),LocalDate.now(),5000.0,null,null,null);
		CitizenPlanEntity e11 = new CitizenPlanEntity("Lina","Fe-Male","Employment", "Denaid",null,null,null,"job holder",null,null);
		CitizenPlanEntity e12 = new CitizenPlanEntity("Raj","Male","Employment", "Terminated",LocalDate.now(),LocalDate.now(),5000.0,null,LocalDate.now(),"got new job");
		
		
		repo.saveAll(Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12));
		
	}

}

