package com.lopes.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lopes.model.Cambio;
import com.lopes.repository.CambioRepository;

@Service
public class CambioService {
	
	@Autowired
	private CambioRepository repository;
	
	@Autowired
	private Environment environment;
	
	@Transactional
	public Cambio save(Cambio cambioRequest) {
		
		Cambio cambio = repository.save(cambioRequest);
		
		if(cambio.getConvertedValue().compareTo(new BigDecimal(50)) == 1) {
			throw new RuntimeException("Erro depois de salvar");
		}
		
		return cambio;
	}
	
	
	public List<Cambio> findAll(){
		return repository.findAll();
	}
	
	public Cambio findById(Long id){
		return repository.findById(id).orElse(null);
	}
	
	public Cambio findByFromTo(BigDecimal value, String from, String to){
		
		List<Cambio> cambios=  repository.findByFromTo(from,to);
		
		if(Objects.nonNull(cambios)) {
			Cambio cambio = cambios.get(0);
			cambio.setConvertedValue(cambio.getConversionFactor().multiply(value));
			cambio.setEnviroment(environment.getProperty("local.server.port"));
			return cambio;
		}
		
		return null;
		
	}

}
