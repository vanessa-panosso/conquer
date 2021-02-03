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
public class Estabelecimento {
	
	@Id
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "natureza_juridica_id")
	private NaturezaJuridica naturezaJuridica;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "municipio_id")
	private Municipio municipio;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cnae_id")
	private Cnae cnae;
}
