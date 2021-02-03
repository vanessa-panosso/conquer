package br.com.conquer.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.conquer.dto.FiltroExportar;
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
	
	@PostMapping("/exportar")
	public void exportarDespesasCSV(@ModelAttribute FiltroExportar filtroExportar, Model model, HttpServletResponse response) throws URISyntaxException, IOException {
		response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/YYYY");
        String dataInicial = dateFormatter.format(filtroExportar.getDataInicial());
        String dataFinal = dateFormatter.format(filtroExportar.getDataFinal());
        String currentDateTime = dateFormatter.format(new Date());
        
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=gastos_municipio_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);
        service.exportarCSV(dataInicial, dataFinal, filtroExportar.isTodasPaginas(), response);
        
	}
	
}
