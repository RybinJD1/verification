package io.manco.task.web;

import io.manco.task.core.CoreApplication;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WebApplication{// extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new SpringApplicationBuilder()
			.bannerMode(Banner.Mode.CONSOLE)
			.sources(CoreApplication.class, WebApplication.class)
			.run(args);
	}

}
