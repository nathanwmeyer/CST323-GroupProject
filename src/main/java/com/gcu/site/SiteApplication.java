package com.gcu.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SiteApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SiteApplication.class, args);
	}

}
