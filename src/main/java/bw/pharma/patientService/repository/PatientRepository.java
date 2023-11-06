package bw.pharma.patientService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bw.pharma.patientService.entity.PatientEntity;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {
	
	public boolean existsById(int id);
	public boolean existsByFirstnameAndLastname(String firstname, String lastname);

}
