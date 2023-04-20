package com.example.location;

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
	
	@GetMapping("/hello")
	public String sayHello(){
		return "Bonjour !";
	}

	@PutMapping("/cars/{plaque}")
	public String getCar(@PathVariable("plaque") String plaque, @RequestParam("rent") boolean rent){
		return plaque + " " + rent;
	}
}
