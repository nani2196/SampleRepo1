package com.slokam.helathcare.patient.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.slokam.helathcare.patient.entity.Patient_Entity;

@Repository
public interface Patient_Repository extends JpaRepository<Patient_Entity, Integer> {
	
	public List<Patient_Entity> findByName(String s); 
	public List<Patient_Entity> findByNameLike(String s);
	
	@Query("from Patient_Entity p where p.name like ?1")
	public List<Patient_Entity> getByPatientName(String nn);
	
	

}
