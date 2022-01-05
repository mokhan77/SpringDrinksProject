package com.qa.SpringDrinks.service;

import java.util.List;

public interface ServiceMethods<T> {

	T create(T t); // Creates

	List<T> getAll(); // Reads all

	T getById(long id); // Reads by id

	T update(long id, T t); // Updates

	boolean delete(long id); // Deletes

}
