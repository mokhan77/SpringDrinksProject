package com.qa.SpringDrinks.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.SpringDrinks.domain.Drink;
import com.qa.SpringDrinks.repo.DrinkRepo;

@SpringBootTest

public class DrinkServiceUnitTest {

	@Autowired
	private DrinkService service;

	@MockBean
	private DrinkRepo repo;

	@Test
	public void createTest() {
		
		Drink input = new Drink("Lemonade", "Yellow", 8);
		Drink output = new Drink(1L, "Lemonade", "Yellow", 8);

		Mockito.when(this.repo.save(input)).thenReturn(output);

		assertEquals(output, this.service.create(input));

		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}

	@Test
	public void getByIdTest() {
		
		Long id = 1L;
		Drink expected = new Drink(id, "Lemonade", "Yellow", 8);

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expected));

		assertEquals(this.service.getById(id), expected);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}

	@Test
	public void getAllTest() {
		
		Long id = 1L;
		Drink testDrink = new Drink("Lemonade", "Yellow", 8);
		testDrink.setId(id);
		List<Drink> listOfDrinks = List.of(testDrink);

		Mockito.when(this.repo.findAll()).thenReturn(listOfDrinks);

		assertEquals(this.service.getAll(), listOfDrinks);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void updateTest() {

		Long id = 1L;
		Drink drink = new Drink("Lemonade", "Yellow", 8);
		Optional<Drink> existingDrink = Optional.of(new Drink(1L, "Orangeade", "Orange", 7));
		Drink updated = new Drink(id, "Lemonade", "Yellow", 8);

		Mockito.when(this.repo.findById(id)).thenReturn(existingDrink);
		Mockito.when(this.repo.saveAndFlush(updated)).thenReturn(updated);

		assertEquals(updated, this.service.update(id, drink));
		;

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(updated);
	}

	@Test
	public void deleteTest() {
		
		Long id = 1L;
		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertEquals(this.service.delete(id), true);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}
}