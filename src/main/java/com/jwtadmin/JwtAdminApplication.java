package com.jwtadmin;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.jwtadmin.entity.Admin;
import com.jwtadmin.repository.AdminRepository;

@SpringBootApplication
@EnableEurekaClient
public class JwtAdminApplication {
	@Autowired
	private AdminRepository repository;

	@PostConstruct
	public void initAdmin() {
		List<Admin> admins = Stream.of(new Admin(1, "admin", "password")

		).collect(Collectors.toList());
		repository.saveAll(admins);
	}

	public static void main(String[] args) {

		SpringApplication.run(JwtAdminApplication.class, args);
	}

}
