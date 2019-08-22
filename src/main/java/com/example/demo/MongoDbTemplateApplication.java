package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Car;
import com.example.demo.model.Dealer;
import com.example.demo.repo.MyRepository;
import com.example.demo.repo.RepositoryImpl;
import com.example.demo.repo.RepositoryImplDealer;

@SpringBootApplication
public class MongoDbTemplateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MongoDbTemplateApplication.class, args);
		
		RepositoryImpl repo = ctx.getBean(RepositoryImpl.class);		
		RepositoryImplDealer repo1 = ctx.getBean(RepositoryImplDealer.class);
		
		
		Dealer dealer = ctx.getBean(Dealer.class);
		Dealer saved = repo1.save(dealer);
				
		Car car = ctx.getBean(Car.class);
		Car saved1 = repo.save(car);
		
		System.out.println("One dealer with details save "+ saved);
		
		System.out.println("One car with details save "+ saved1);
		
		System.out.println(repo.findAll());
		
		ctx.close();
	}

}
