package com.example.demo.config;

import java.util.Arrays;
import java.util.Random;

import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.example.demo.model.Address;
import com.example.demo.model.Car;
import com.example.demo.model.Dealer;
import com.example.demo.model.Owner;
import com.example.demo.repo.MyRepository;
import com.example.demo.repo.RepositoryImpl;
import com.mongodb.MongoClient;

@Configuration
public class AppConfig {
	
	@Bean
	public MongoClient client() {
		
		return new MongoClient("localhost");
	}

	@Bean
	public MongoTemplate template() {
		
		return new MongoTemplate(client(),"training");
	}
	
	@Bean
	public Owner owner() {
		
		return new Owner(108, "Achee", address());
	}
	
	@Bean
	public Address address() {
		
		return new Address("Coimbatore", 600017);
	}
	
	@Bean
	public Dealer dealer() {
		
		Dealer dealer = new Dealer();
		dealer.setDealerName("Ramani Nissan");
		return dealer;
	}
	
	@Bean
	public Car car() {
		
		Car car = new Car();
		car.setBrand("Porsche");
		car.setModel(Arrays.asList("Macan", "Cayman", "Boxster", "Cayenne"));
		
		car.setOwner(owner());
		car.setDealer(dealer());
		return car;
	}

}
