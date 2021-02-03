package br.com.conquer.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Vanessa Panosso
 * 
 */
@Getter
@Setter
@Entity
@Table(name = "despesa")
public class Despesa {
	
	@Id
	private Integer id;
	private LocalDate dataTransacao;
	private String mesExtrato;
	private BigDecimal valorTransacao;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "estabelecimento_id")
	private Estabelecimento estabelecimento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tipo_cartao_id")
	private TipoCartao tipoCartao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "unidade_gestora_id")
	private UnidadeGestora unidadeGestora;
}
