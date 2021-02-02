package br.com.conquer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.conquer.dto.DespedaDTO;
import br.com.conquer.mapper.DespesaMapper;
import br.com.conquer.service.DespesaService;

/**
 * 
 * @author Vanessa Panosso
 * 
 */
@RestController
@RequestMapping("/despesas")
public class DespesaController {
	
	@Autowired
	private DespesaService service;
	
	@Autowired
	private DespesaMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<DespedaDTO>> find() {
		final List<DespedaDTO> list = mapper.toDto(service.findAll());
		return new ResponseEntity<List<DespedaDTO>>(list, HttpStatus.OK);
	}
}
