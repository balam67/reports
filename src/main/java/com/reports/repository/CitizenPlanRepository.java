package com.reports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reports.entity.CitizenPlanEntity;

@Repository
public interface CitizenPlanRepository extends JpaRepository<CitizenPlanEntity, Integer> {

	@Query(value="select distinct(planName) from CitizenPlanEntity")
	public List<String> getPlanNames();	
	@Query(value="select distinct(planStatus) from CitizenPlanEntity")
	public List<String> getPlanStatuses();
}



