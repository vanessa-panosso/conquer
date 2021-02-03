package br.com.conquer.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
public class OrgaoVinculado {

	@Id
	private String cnpj;
	private String codigoSiafi;
	private String descricaoPoder;
	private String nome;
	private String sigla;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orgao_maximo_id")
	private OrgaoMaximo orgaoMaximo;
}
