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
public class UnidadeGestora {

	@Id
	private String codigo;
	private String nome;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orgao_vinculado_id")
	private OrgaoVinculado orgaoVinculado;
}
