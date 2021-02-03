package br.com.conquer.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiltroExportar {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataInicial;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataFinal;
    
    private boolean todasPaginas;
}
