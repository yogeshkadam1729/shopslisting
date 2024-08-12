package com.roboelectric.shopslisting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ShopslistingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopslistingApplication.class, args);
	}

}
