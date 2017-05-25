package com.mrcai;

import com.mrcai.socket.SocketListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class WaterLevelApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(WaterLevelApplication.class);
//		springApplication.addListeners(new SocketListener());
		springApplication.run(args);
	}

}
