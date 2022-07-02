package com.philips.hackathon.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.hackathon.dao.PatientRepository;
import com.philips.hackathon.models.Patient;
import com.philips.hackathon.models.Request;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public void savePatient(Request request) {
		patientRepository.save(new Patient(null, request.getAge(), request.getOxyLvl(),
			LocalDateTime.now()));
		log.info("Patient data saved to database...");
	}

	public List<Patient> findAllPatients() {
		log.info("Returning all patients found in database...");
		return patientRepository.findAll();
	}

}
