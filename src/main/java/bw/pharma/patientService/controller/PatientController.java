package bw.pharma.patientService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bw.pharma.patientService.entity.PatientEntity;
import bw.pharma.patientService.model.Patient;
import bw.pharma.patientService.service.PatientService;

@RestController
@CrossOrigin(origins="127.0.0.1")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@RequestMapping (value = "getPatients", method = RequestMethod.GET)
	public List<Patient> getPatients() throws Exception{
		return patientService.getAllPatients();
	}
	
	@RequestMapping(value= "addPatient", method = RequestMethod.POST)
	public String addPatient(@RequestBody PatientEntity patient) {
		return patientService.addPatient(patient);
	}
	
	@RequestMapping(value= "updatePatient", method = RequestMethod.PUT)
	public String updatePatient(@RequestBody PatientEntity patient) {
		return patientService.updatePatient(patient);
	}
	
	@RequestMapping(value= "removePatient", method = RequestMethod.DELETE)
	public String removePatient(@RequestBody PatientEntity patient) {
		return patientService.removePatient(patient);
	}

}
