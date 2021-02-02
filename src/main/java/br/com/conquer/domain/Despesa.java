package br.com.conquer.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
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
	private String dataTransacao;
	private String mesExtrato;
	private String valorTransacao;

	@ManyToOne
	private Estabelecimento estabelecimento;
	@ManyToOne
	private TipoCartao tipoCartao;
	@ManyToOne
	private UnidadeGestora unidadeGestora;
}
