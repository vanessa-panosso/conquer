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
public class TipoCartao {

	@Id
	private Integer id;
	private String codigo;
	private String descricao;
}
