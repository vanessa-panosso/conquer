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
public class Cnae {
	
	@Id
	private Integer id;
	private String codigoClassse;
	private String classe;
	private String codigoDivisao;
	private String codigoGrupo;
	private String codigoSecao;
	private String codigoSubclasse;
	private String divisao;
	private String grupo;
	private String secao;
	private String subclasse;
}
