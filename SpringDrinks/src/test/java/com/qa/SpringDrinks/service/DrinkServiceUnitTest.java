package com.qa.SpringDrinks.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
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
	void tgetByIdTest() {

		Long id = 1L;
		Drink expected = new Drink(id, "Lemonade", "Yellow", 8);

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expected));

		Assertions.assertThat(this.service.getById(id)).isEqualTo(expected);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}

	@Test
	void testReadAll() {

		Long id = 1L;
		Drink testDrink = new Drink("Lemonade", "Yellow", 8);
		testDrink.setId(id);
		List<Drink> listOfDrinks = List.of(testDrink);

		Mockito.when(this.repo.findAll()).thenReturn(listOfDrinks);

		Assertions.assertThat(this.service.getAll()).isEqualTo(listOfDrinks);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void updateTest() {

		Long id = 1L;
		Drink drink = new Drink("Lemonade", "Yellow", 8);
		Drink existing = new Drink(id, "Orangeade", "Orange", 7);
		Drink updated = new Drink(id, drink.getName(), drink.getColour(), drink.getTaste());

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existing));
		Mockito.when(this.repo.save(updated)).thenReturn(updated);

		Assertions.assertThat(this.service.update(id, drink)).isEqualTo(updated);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(updated);
	}

	@Test
	void deleteTest() {

		Long id = 1L;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		Assertions.assertThat(this.service.delete(id)).isTrue();

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}
}