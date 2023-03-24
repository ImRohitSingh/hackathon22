package com.philips.hackathon.messaging;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.philips.hackathon.models.Patient;
import com.philips.hackathon.service.PatientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StreamSink {

	@Autowired
	private PatientService patientService;

	private int count = 0;

	@Bean
	public Consumer<Patient> patientConsumer() {
		return payload -> {
			++count;
			log.info("Sink (consumed): {}", payload);
			if (count % 15 == 0) {
				log.info("Saving consumed item to database...");
				patientService.savePatient(payload);
			}

			if (count == Integer.MAX_VALUE) {
				count = 0;
			}
		};
	}

}
