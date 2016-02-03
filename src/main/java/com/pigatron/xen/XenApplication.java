package com.pigatron.xen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class XenApplication {
	public static void main(String[] args) {
		SpringApplication.run(XenApplication.class, args);
	}
}
