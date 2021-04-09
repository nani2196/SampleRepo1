package com.slokam.helathcare.patient.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.helathcare.patient.Repository.Patient_Repository;
import com.slokam.helathcare.patient.entity.Patient_Entity;

@RestController
public class Patient_Controller {
	
	@Autowired
	private Patient_Repository repo;
	
	@PostMapping("save")
	public ResponseEntity<Patient_Entity> saveData(@RequestBody Patient_Entity pe){
		
		repo.save(pe);
		
		return new ResponseEntity<Patient_Entity>(HttpStatus.CREATED);
		
	}
	
	@GetMapping("getdata/{i}")
	public ResponseEntity<Patient_Entity> getDataById(@PathVariable Integer i){
		
		Optional<Patient_Entity> oppo=repo.findById(i);
		
		if(oppo.isPresent()){
			
			return new ResponseEntity<Patient_Entity>(oppo.get(),HttpStatus.OK);
		}
		return new ResponseEntity<Patient_Entity>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("alldetails")
	public ResponseEntity<List<Patient_Entity>> getAllDetails(){
		List<Patient_Entity> list=repo.findAll();
		if(list.isEmpty()) {
			return new ResponseEntity<List<Patient_Entity>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Patient_Entity>>(list,HttpStatus.OK);
		
		
	}
	@PutMapping("update")   
	public ResponseEntity<Patient_Entity> updateData(@RequestBody Patient_Entity pe){
		repo.save(pe);
		return new ResponseEntity<Patient_Entity>(HttpStatus.OK);
		
	}
	@DeleteMapping("delete/{ii}")
	public ResponseEntity<Patient_Entity> deleteData(@PathVariable Integer ii){
		
		repo.deleteById(ii);
		return new ResponseEntity<Patient_Entity>(HttpStatus.OK);
		
	}
	@GetMapping("bypatient/{name}")
	public ResponseEntity<List<Patient_Entity>> findByPatient(@PathVariable String name){
		List<Patient_Entity> list =repo.findByName(name);
		
		return new ResponseEntity<List<Patient_Entity>>(list,HttpStatus.OK);
		
	}
	@GetMapping("namelike/{nn}")
	public ResponseEntity<List<Patient_Entity>> findBynamelike(@PathVariable String nn){
		List<Patient_Entity> list =repo.findByNameLike("%"+nn+"%");
		
		
		return new ResponseEntity<List<Patient_Entity>>(list,HttpStatus.OK);
		
	}
	@GetMapping("byquery/{nn}")
	public ResponseEntity<List<Patient_Entity>> getByPatient(@PathVariable String nn){
		
	List<Patient_Entity> pe=	repo.getByPatientName("%"+nn+"%");
	
	return new ResponseEntity<List<Patient_Entity>>(pe,HttpStatus.OK);
	}
	

}
