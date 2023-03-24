package com.philips.hackathon.messaging;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.philips.hackathon.configs.RabbitConfiguration;
import com.philips.hackathon.models.Patient;
import com.philips.hackathon.service.PatientService;

@DirtiesContext
@SpringBootTest(properties = { "spring.cloud.stream.poller.fixed-delay=1000" })
@SpringJUnitConfig(classes = { StreamSource.class, StreamSink.class,
		RabbitConfiguration.class })
class StreamMessagingTest {

	@Autowired
	private Supplier<Patient> patientProducer;

	@Autowired
	private Consumer<Patient> patientConsumer;

	@MockBean
	private MessageConverter mockJacksonMessageConverter;

	@MockBean
	private PatientService mockPatientService;

	@Test
	void test() {
		Patient actualPatient = patientProducer.get();
		assertNull(actualPatient.getSsn());

		patientConsumer.accept(actualPatient);

		verify(mockPatientService, times(0)).savePatient(actualPatient);

		doNothing().when(mockPatientService).savePatient(any(Patient.class));

		for (int i = 0; i < 14; ++i) {
			patientConsumer.accept(actualPatient);
		}

		verify(mockPatientService, times(1)).savePatient(actualPatient);
	}

}
