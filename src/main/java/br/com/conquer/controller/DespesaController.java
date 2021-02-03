package br.com.conquer.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.conquer.dto.DespesaDTO;
import br.com.conquer.dto.FiltroExportar;
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
	public ResponseEntity<List<DespesaDTO>> find() {
		final List<DespesaDTO> list = mapper.toDtos(service.findAll());
		return new ResponseEntity<List<DespesaDTO>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/exportar")
	public ResponseEntity<String> exportarDespesasCSV(@RequestBody FiltroExportar filtroExportar) throws URISyntaxException {
		return new ResponseEntity<String>(service.exportarCSV(filtroExportar.getDataInicial(), filtroExportar.getDataFinal()), HttpStatus.OK);
	}
}
