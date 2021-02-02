package br.com.conquer.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Vanessa Panosso
 * 
 */
@Getter
@Setter
public class UnidadeGestoraDTO {

	private String codigo;
	private String nome;
	private OrgaoVinculadoDTO orgaoVinculado;
}
