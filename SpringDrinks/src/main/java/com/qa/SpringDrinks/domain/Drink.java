package com.qa.SpringDrinks.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Drink {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	@NotNull(message = "Cannot be null")
	private String name; // Name of brand or drink

	@Column
	private String colour; // Colour of liquid

	@Column
	private long taste; // Taste rating out of 10

	public Drink() {

	}

	// For testing
	public Drink(long id, String name, String colour, long taste) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.taste = taste;
	}

	// For creating
	public Drink(String name, String colour, long taste) {
		super();
		this.name = name;
		this.colour = colour;
		this.taste = taste;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public long getTaste() {
		return taste;
	}

	public void setTaste(long taste) {
		this.taste = taste;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (taste ^ (taste >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drink other = (Drink) obj;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (taste != other.taste)
			return false;
		return true;
	}
	

}
