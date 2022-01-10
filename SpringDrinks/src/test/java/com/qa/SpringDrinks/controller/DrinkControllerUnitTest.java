package com.qa.SpringDrinks.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.qa.SpringDrinks.domain.Drink;
import com.qa.SpringDrinks.service.DrinkService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DrinkControllerUnitTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private DrinkService service;

	@Test
	public void createTest() throws Exception {
		Drink entry = new Drink("Strawberry Milkshake", "Pink", 7);
		String entryAsJSON = this.mapper.writeValueAsString(entry);

		Mockito.when(this.service.create(entry)).thenReturn(entry);

		mvc.perform(post("/drink/create").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(status().isCreated()).andExpect(content().json(entryAsJSON));
	}

	@Test
	public void getByIdTest() throws Exception {

	}

	@Test
	public void getAllTest() throws Exception {
		Drink entry = new Drink("Fanta", "Orange", 7);

		List<Drink> newDrink = new ArrayList<>();
		newDrink.add(entry);
		String newDrinkAsJSON = this.mapper.writeValueAsString(newDrink);

		Mockito.when(this.service.getAll()).thenReturn(newDrink);

		mvc.perform(get("/drink/getAll").contentType(MediaType.APPLICATION_JSON).content(newDrinkAsJSON))
				.andExpect(status().isOk()).andExpect(content().json(newDrinkAsJSON));
	}

	@Test
	public void updateTest() throws Exception {

	}

	@Test
	public void deleteTest() throws Exception {

	}
}