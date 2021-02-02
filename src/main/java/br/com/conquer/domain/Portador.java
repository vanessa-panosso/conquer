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
public class Portador {

	@Id
	private String codigoFormatacao;
	private String nome;
}
