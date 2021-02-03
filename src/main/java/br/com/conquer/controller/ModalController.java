package br.com.conquer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.conquer.dto.DespesaDTO;
import br.com.conquer.dto.FiltroExportar;
import br.com.conquer.mapper.DespesaMapper;
import br.com.conquer.service.DespesaService;

@Controller
@RequestMapping({ "/", "/form-exportar" })
public class ModalController {

	@Autowired
	private DespesaService service;
	
	@Autowired
	private DespesaMapper mapper;
	
    @GetMapping
    public String main(Model model) {
        model.addAttribute("filtroExportar", new FiltroExportar());
        return "form-exportar";
    }
    
	@GetMapping("despesas")
	public String find(Model model) {
		final List<DespesaDTO> list = mapper.toDtos(service.findAll());
		model.addAttribute("despesas", list);
		return "tabela-despesas";
	}
}
