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
public class MunicipioDTO {
	private String codigoIBGE;
	private String nomeIBGE;
	private String pais;
	private UfDTO uf;
}
