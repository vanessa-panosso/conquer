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
public class EstabelecimentoDTO {
	private String codigoFormatado;
	private String complementoEndereco;
	private String dataAbertura;
	private String descricaoLogradouro;
	private String enderecoEletronico;
	private String localidadePessoa;
	private String nome;
	private String nomeBairro;
	private String nomeFantasiaReceita;
	private String numeroCEP;
	private String numeroEndereco;
	private String numeroTelefone;
	private String razaoSocialReceita;
	private String tipoCodigo;
	private String tipoPessoa;
	private NaturezaJuridicaDTO naturezaJuridica;
	private MunicipioDTO municipio;
	private CnaeDTO cnae;
}
