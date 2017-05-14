package com.mrcai;

import com.mrcai.socket.SocketListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WaterLevelApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(WaterLevelApplication.class);
		springApplication.addListeners(new SocketListener());
		springApplication.run(args);
	}
}
