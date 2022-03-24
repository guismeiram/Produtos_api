package com.produtos_api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.produtos_api.models.Produto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"id","nome","quantidade","valor"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProdutosDto extends RepresentationModel<ProdutosDto> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private long id;
	@JsonProperty("nome")
	private String nome;
	@JsonProperty("quantidade")
	private BigDecimal quantidade;
	@JsonProperty("valor")
	private BigDecimal valor;
	
	
	public static ProdutosDto create(Produto produto) {
		return new ModelMapper().map(produto, ProdutosDto.class);
	}
}
