package com.qa.SpringDrinks.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class DrinkTest {

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Drink.class).usingGetClass().verify();
	}

	@Test
	public void noIdConstructor() {
		Drink drink = new Drink("Lucozade", "Orange", 7);

		assertNotNull(drink.getName());
		assertNotNull(drink.getColour());
		assertNotNull(drink.getTaste());

		assertEquals(drink.getName(), "Lucozade");
		assertEquals(drink.getColour(), "Orange");
		assertEquals(drink.getTaste(), 7);

	}

	@Test
	public void setterTest() {
		Drink drink = new Drink();

		drink.setName("Sprite");
		drink.setColour("Clear");
		drink.setTaste(6);

		assertNotNull(drink.getName());
		assertNotNull(drink.getColour());
		assertNotNull(drink.getTaste());

		assertEquals(drink.getName(), "Sprite");
		assertEquals(drink.getColour(), "Clear");
		assertEquals(drink.getTaste(), 6);
	}
}
