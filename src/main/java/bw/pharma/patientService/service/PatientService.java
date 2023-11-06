package bw.pharma.patientService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bw.pharma.patientService.entity.PatientEntity;
import bw.pharma.patientService.model.Patient;
import bw.pharma.patientService.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
public List<Patient> getAllPatients() throws Exception {
		
		try{
				List<PatientEntity> patients = patientRepository.findAll();
				List<Patient> customPatients = new ArrayList<>();
				patients.stream().forEachOrdered(d -> {
					Patient patient = new Patient();
					BeanUtils.copyProperties(d, patient);
					customPatients.add(patient);
				});
				return customPatients;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public String addPatient(PatientEntity patient) {
		
		try {
			if(!patientRepository.existsByFirstnameAndLastname(patient.getFirstname(), patient.getLastname())) {
				patientRepository.save(patient);
				return "Patient added successfully";
				
			}else {return "Patient already exists";}
		}
		catch(Exception ex) {
			throw ex;
		}
	
	}
	public String removePatient(PatientEntity patient) {
		
		try {
			if(patientRepository.existsByFirstnameAndLastname(patient.getFirstname(), patient.getLastname())) {
				patientRepository.delete(patient);
				return "Patient removed from list successfully";
			}
			else {return "Patient does not exist";}
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}
		
	public String updatePatient(PatientEntity patient) {
		try {
			if(patientRepository.existsByFirstnameAndLastname(patient.getFirstname(), patient.getLastname())) {
				patientRepository.save(patient);
				return "Patient details updated successfully";
			}
			else {return "Patient does not exist";}
		}
		catch(Exception ex) {
			throw ex;
		}
	}

}
