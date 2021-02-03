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
public class DespesaDTO {
	private Integer id;
	private EstabelecimentoDTO estabelecimento;
	private String dataTransacao;
	private String mesExtrato;
	private TipoCartaoDTO tipoCartao;
	private UnidadeGestoraDTO unidadeGestora;
	private String valorTransacao;
}
