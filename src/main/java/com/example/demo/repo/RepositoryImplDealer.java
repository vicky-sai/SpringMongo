package com.example.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;import com.example.demo.model.Dealer;

@Repository
public class RepositoryImplDealer implements MyRepository<Dealer> {

	@Autowired
	private MongoTemplate template;
	
	@Override
	public Dealer save(Dealer t) {
		
		return template.save(t);
	}

	@Override
	public List<Dealer> findAll() {
		
		return template.findAll(Dealer.class);
	}
	
	@Override
	public long remove(Dealer t) {
		
		return template.remove(t).getDeletedCount();
	}


}
