package com.anthony.loginuser.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.anthony.loginuser.models.Planet;

public interface PlanetRepository extends CrudRepository<Planet, Long> {
	public List<Planet>findAll();

	public Planet getById(Long id);
}
