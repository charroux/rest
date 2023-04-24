package com.example.location;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CarRentalService {

	Car ferrari = new Car();

	/**
	 * PUT
	 * http://localhost:8080/cars/22BB33?prix=3000
	 * @param plaque
	 * @param prix
	 * @return
	 */
	@PutMapping("/cars/{plaque}")
	public Car getCar(@PathVariable("plaque") String plaque, @RequestParam("prix") int prix){
		ferrari.setPlaque(plaque);
		ferrari.setPrix(prix);
		return ferrari;
	}

	/**
	 * Créer une voiture
	 * @param plaque
	 * @param prix
	 * @return
	 */
	@PostMapping("/cars/{plaque}")
	public Car createCar(@PathVariable("plaque") String plaque, @RequestParam("prix") int prix){
		ferrari = new  Car();
		ferrari.setPlaque(plaque);
		ferrari.setPrix(prix);
		return ferrari;
	}

	/**
	 * GET
	 * http://localhost:8080/cars/22BB33
	 * @param plaque
	 * @return
	 */
	@GetMapping("/cars/{plaque}")
	public Car getCar(@PathVariable("plaque") String plaque){
		if(ferrari.getPlaque().equals(plaque)){
			return ferrari;
		}
		return null;
	}

	/**
	 * http://localhost:8080/cars?prix=3000
	 * @param prix
	 * @return
	 */
	@GetMapping("/cars")
	public Car getCar1(@RequestParam("prix") int prix){
		if(ferrari.getPrix() == prix){
			return ferrari;
		}
		return null;
	}

	/**
	 * Supprimer une voiture
	 * @param plaque
	 * @return
	 */
	@DeleteMapping("/cars/{plaque}")
	public boolean deleteCar(@PathVariable("plaque") String plaque){
		if(ferrari.getPlaque().equals(plaque)){
			ferrari = null;
			return true;
		}
		return false;
	}
}
