package com.qa.SpringDrinks.service;

import java.util.List;

public interface ServiceMethods<T> {

	T create(T t); // Create

	List<T> getAll(); // Read all

	T getById(long id); // Read by id

	T update(long id, T t); // Update

	boolean delete(long id); // Delete

}
