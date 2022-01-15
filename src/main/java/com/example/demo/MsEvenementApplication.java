package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.dao.EvenementRepository;
import com.example.demo.entities.Evenement;

@SpringBootApplication
@EnableDiscoveryClient
public class MsEvenementApplication implements CommandLineRunner {
	@Autowired
	EvenementRepository EvenementRepository;
	@Autowired

	RepositoryRestConfiguration repositoryRestConfig;

	public static void main(String[] args) {
		SpringApplication.run(MsEvenementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfig.exposeIdsFor(Evenement.class);
		Evenement event1 = new Evenement("service oriented architecture", null, "book");
		EvenementRepository.save(event1);
		Evenement event2 = new Evenement("bitcoin", null, "white paper");
		EvenementRepository.save(event2);

	}

}
