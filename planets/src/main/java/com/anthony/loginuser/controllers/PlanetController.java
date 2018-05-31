package com.anthony.loginuser.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anthony.loginuser.models.Moon;
import com.anthony.loginuser.models.Planet;
import com.anthony.loginuser.service.MoonService;
import com.anthony.loginuser.service.PlanetService;

@Controller
public class PlanetController {
	private final PlanetService planetService;
	private final MoonService moonService;
	
	public PlanetController(PlanetService planetService,MoonService moonService) {
		this.planetService = planetService;
		this.moonService = moonService;
	}

//	@RequestMapping("/planets/new")
//	public String newPlanet(@ModelAttribute("planet") Planet planet) {
//		return "newPlanet.jsp";
//	}
//	
//	@PostMapping("/planets/new")
//	public String addPlanet(@Valid @ModelAttribute("planet")Planet planet, BindingResult result, Principal principal) {
//		// check for errors
//		if(result.hasErrors()) {
//			// if not errors, save
//			return "newPlanet.jsp";
//		} else {
//			// if errors, display messages
//			planetService.addPlanet(planet);
//			return "redirect:/";
//		}
//	}
	
	// show planet, add moon
	@GetMapping("/planets/{id}")
	public String showPlanet(@PathVariable("id")Long id, Model model, @ModelAttribute("moon")Moon moon) {
		// get a planet based on id
		Planet planet = planetService.getPlanet(id);
		model.addAttribute("planet", planet);
		return "showPlanet.jsp";
	}
	
	// add a moon to a planet
//	@PostMapping("/planets/{id}/addMoon")
//	public String addMoon(@Valid @ModelAttribute("moon")Moon moon, BindingResult result, @PathVariable("id")Long id, Model model) {
//		Planet planet = planetService.getPlanet(id);
//		if(result.hasErrors()) {
//			model.addAttribute("planet", planet);
//			return "showPlanet.jsp";
//		} else {
//			// add the moon
//			moonService.addMoon(planet, moon);
//			return "redirect:/planets/" + id;
//		}
//	}
	
//	@RequestMapping("/planets/{id}/edit")
//	public String editPlanet(@PathVariable("id")Long id, Model model) {
//		Planet planet = planetService.getPlanet(id);
//		model.addAttribute("planet", planet);
//		return "editPlanet.jsp";
//	}
//	
//	@PostMapping("/planets/{id}")
//	public String updatePlanet(@Valid @ModelAttribute("planet")Planet planet, BindingResult result, @PathVariable("id")Long id, Model model) {
//		// get a planet based on id
//		if(result.hasErrors()) {
//			model.addAttribute("planet", planet);
//			return "editPlanet.jsp";
//		} else {
//			// update planet
//			planetService.addPlanet(planet);
//			return "redirect:/planets/" + id;
//		}
//	}
	
	@GetMapping("/planets/{id}/destroy")
	public String deletePlanet(@PathVariable("id")Long id) {
		planetService.destroyPlanet(id);
		return "redirect:/";
	}
}
