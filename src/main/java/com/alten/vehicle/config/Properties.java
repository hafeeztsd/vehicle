package com.alten.vehicle.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "config")
@EnableConfigurationProperties
@RefreshScope
public class Properties {

	private long pingDelay;

	public long getPingDelay() {
		return pingDelay;
	}

	public void setPingDelay(long pingDelay) {
		this.pingDelay = pingDelay;
	}


	

	
}
