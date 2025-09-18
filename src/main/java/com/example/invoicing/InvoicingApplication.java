package com.example.invoicing;

import com.example.invoicing.config.InvoicingConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(InvoicingConfig.class)
public class InvoicingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(InvoicingApplication.class, args);
		InvoicingConfig config = context.getBean(InvoicingConfig.class);
		System.out.println("Address: " + config.getAddress());
		System.out.println("Port: " + config.getPort());
	}
}
