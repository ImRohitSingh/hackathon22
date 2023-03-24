package com.philips.hackathon.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.philips.hackathon.dao.PatientRepository;
import com.philips.hackathon.models.Request;
import com.philips.hackathon.service.PatientService;

@WebMvcTest
@AutoConfigureMockMvc
@SpringJUnitConfig(classes = { PatientController.class, PatientService.class,
		PatientRepository.class })
class PatientControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PatientRepository patientRepository;

	@Mock
	private PatientService mockPatientService;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void testSavePatient() throws JsonProcessingException, Exception {
		Request testRequest = new Request();
		testRequest.setAge(10);
		testRequest.setOxyLvl(56.2);

		doNothing().when(mockPatientService).savePatient(any(Request.class));

		mockMvc
			.perform(post("/save").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(testRequest)))
			.andDo(print()).andExpect(status().isCreated());

	}

	@Test
	void testFindAllPatients() throws JsonProcessingException, Exception {

		doReturn(Collections.emptyList()).when(mockPatientService).findAllPatients();

		mockMvc.perform(get("/findAll")).andDo(print()).andExpect(status().isOk());

	}

}
