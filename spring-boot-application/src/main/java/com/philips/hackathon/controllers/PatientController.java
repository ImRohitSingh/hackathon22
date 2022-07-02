package com.philips.hackathon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.philips.hackathon.models.Patient;
import com.philips.hackathon.models.Request;
import com.philips.hackathon.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping(path = "/save")
	@ResponseStatus(code = HttpStatus.CREATED, reason = "Patient data saved")
	public void savePatient(@RequestBody Request request) {
		// TODO: validation for age and oxyLvl and return failure codes accordingly
		patientService.savePatient(request);
	}

	@GetMapping(path = "/findAll")
	public ResponseEntity<List<Patient>> findAllPatients() {
		return new ResponseEntity<>(patientService.findAllPatients(), HttpStatus.OK);
	}

}
