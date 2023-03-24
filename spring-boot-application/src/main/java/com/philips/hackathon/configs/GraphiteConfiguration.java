package com.philips.hackathon.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class GraphiteConfiguration {
	
	@Value("${management.metrics.export.graphite.tags-as-prefix}")
	private String commonTag;

	@Bean
	public MeterRegistryCustomizer<MeterRegistry> commonTags() {
		return r -> r.config().commonTags(commonTag, "hackathon22-spring-app");
	}
	
}
