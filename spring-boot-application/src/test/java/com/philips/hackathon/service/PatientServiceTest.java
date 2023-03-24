package com.philips.hackathon.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.philips.hackathon.dao.PatientRepository;
import com.philips.hackathon.models.Patient;
import com.philips.hackathon.models.Request;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

	@Mock
	private PatientRepository mockPatientRepository;

	@InjectMocks
	private PatientService patientService;

	private Request testRequest;

	private Patient testPatient;

	@BeforeEach
	void createTestData() {
		testRequest = new Request();
		testRequest.setAge(10);
		testRequest.setOxyLvl(56.2);

		testPatient = new Patient(1, 10, 56.2, LocalDateTime.now());
	}

	@Test
	void testSavePatient_when_request_passed() {
		when(mockPatientRepository.save(any(Patient.class))).thenReturn(testPatient);

		patientService.savePatient(testRequest);

		verify(mockPatientRepository, times(1)).save(any(Patient.class));
	}

	@Test
	void testSavePatient_when_patient_passed() {
		when(mockPatientRepository.save(any(Patient.class))).thenReturn(testPatient);

		patientService.savePatient(testPatient);

		verify(mockPatientRepository, times(1)).save(any(Patient.class));
	}

	@Test
	void testfindAllPatients() {
		when(mockPatientRepository.findAll())
			.thenReturn(Arrays.asList(new Patient[] { testPatient }));

		List<Patient> actualResponse = patientService.findAllPatients();

		verify(mockPatientRepository, times(1)).findAll();
		assertEquals(10, actualResponse.get(0).getAge());
	}

}
