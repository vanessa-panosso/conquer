package br.com.conquer.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Municipio {
	
	@Id
	private String codigoIbge;
	private String nomeIbge;
	private String pais;
	
	@ManyToOne
	private Uf uf;
}
