package com.anthony.loginuser.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.anthony.loginuser.models.Planet;
import com.anthony.loginuser.repositories.PlanetRepository;

@Service
public class PlanetService {
	
	private PlanetRepository planetRepository;

	public PlanetService(PlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}
	
	public List<Planet> getAllPlanets(){
		// returns result of the planet repo
		return planetRepository.findAll();
	}

	public void addPlanet(@Valid Planet planet) {
		planetRepository.save(planet);
		
	}

	public Planet getPlanet(Long id) {
		return planetRepository.getById(id);
	}

	public void destroyPlanet(Long id) {
		planetRepository.deleteById(id);
	}
}
