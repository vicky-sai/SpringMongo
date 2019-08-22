package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.model.Car;

@Repository
public interface MyRepository<T> {
	
	public T save(T t);
	
	public List<T> findAll();
	
	long remove(T t);

}