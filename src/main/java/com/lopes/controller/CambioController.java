package com.lopes.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lopes.model.Cambio;
import com.lopes.service.CambioService;

@RestController
@RequestMapping(value = "cambio-service")
public class CambioController implements Serializable {

	private static final long serialVersionUID = -3519264054515237328L;
	
	@Autowired
	private CambioService service;
	
	
	@GetMapping(value = "/{value}/{from}/{to}")
	public Cambio getCambio(@PathVariable(value = "value") BigDecimal value ,@PathVariable(value = "from") String from,@PathVariable(value = "to") String to) {
		return service.findByFromTo(value, from, to);
	}
	
	@PostMapping
	public Cambio save(@RequestBody Cambio cambio) {
		return service.save(cambio);
	}
	
	@GetMapping
	public List<Cambio> findAll() {
		return service.findAll();
	}
	
	

}
