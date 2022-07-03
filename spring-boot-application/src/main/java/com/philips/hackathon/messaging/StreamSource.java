package com.philips.hackathon.messaging;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.philips.hackathon.models.Patient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StreamSource {

	private final Random RANDOM = new Random(10);

	@Bean
	public Supplier<Patient> patientProducer() {
		return () -> {
			Patient patient = new Patient(null, RANDOM.nextInt(90),
				Double.valueOf(String.format("%.2f",
					85.0 + RANDOM.nextInt(15) + RANDOM.nextDouble())),
				LocalDateTime.now());
			log.info("Source (producing): {}", patient);
			return patient;
		};
	}

}
