package com.qa.SpringDrinks.controller;

	import java.util.List;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.qa.SpringDrinks.domain.Drink;
	import com.qa.SpringDrinks.service.DrinkService;

	@RestController
	@RequestMapping("/drink")
	public class DrinkController {

		private DrinkService service;
		
		private DrinkController(DrinkService service) {
			this.service = service;
		}
		
		//Create
		@PostMapping("/create")
		public ResponseEntity<Drink> createDrink(@RequestBody Drink drink) {
			return new ResponseEntity<>(this.service.create(drink), HttpStatus.CREATED);				
		}
		//Read All
		@GetMapping("/getAll")
		public ResponseEntity<List<Drink>> getAllDrink() {
			return new ResponseEntity<List<Drink>>(this.service.getAll(), HttpStatus.OK);
		}
		
		//Read By id
		@GetMapping("/getId/{id}")
		public ResponseEntity<Drink> getIdDrink(@PathVariable Long id) {
			return new ResponseEntity<Drink>(this.service.getById(id), HttpStatus.OK);
		}
		//update
				@PutMapping("/update/{id}")
				public ResponseEntity<Drink> updateDrink(@PathVariable Long id, @RequestBody Drink drink) {
					return new ResponseEntity<Drink>(this.service.update(id, drink), HttpStatus.ACCEPTED);	
				}
				
				//Delete
				@DeleteMapping("/delete/{id}")
				public ResponseEntity<Boolean> deleteDrink(@PathVariable long id){
					//If statement below sort of
					return (this.service.delete(id)) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : 
						new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				
			}

		
	
