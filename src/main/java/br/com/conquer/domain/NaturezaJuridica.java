package br.com.conquer.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

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
public class NaturezaJuridica {

	@Id
	private String codigo;
	private String codigoTipo;
	private String descricao;
	private String descricaoTipo;
}
