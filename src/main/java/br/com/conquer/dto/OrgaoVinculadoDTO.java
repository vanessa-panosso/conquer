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
public class OrgaoVinculadoDTO {
	private String cnpj;
	private String codigoSIAFI;
	private String descricaoPoder;
	private String nome;
	private OrgaoMaximoDTO orgaoMaximo;
	private String sigla;
}
