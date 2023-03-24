package com.philips.hackathon.configs;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

class GraphiteConfigurationTest {

	ApplicationContextRunner applicationContextRunner = new ApplicationContextRunner()
		.withUserConfiguration(GraphiteConfiguration.class);

	@Test
	void testCommonTags() {
		applicationContextRunner.run(it -> {
			assertThat(it).getBean("commonTags")
				.isInstanceOf(MeterRegistryCustomizer.class);
		});
	}

}
