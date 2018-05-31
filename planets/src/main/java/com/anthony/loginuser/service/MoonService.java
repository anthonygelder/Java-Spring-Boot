package com.anthony.loginuser.service;

import org.springframework.stereotype.Service;

import com.anthony.loginuser.models.Moon;
import com.anthony.loginuser.models.Planet;
import com.anthony.loginuser.repositories.MoonRepository;

@Service
public class MoonService {
	private final MoonRepository moonRepository;
	
	
	public MoonService(MoonRepository moonRepository) {
		this.moonRepository = moonRepository;
	}

	public void addMoon(Planet planet, Moon moon) {
		moon.setPlanet(planet);
		moonRepository.save(moon);
	}
}
