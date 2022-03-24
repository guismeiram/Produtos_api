package com.produtos_api.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.produtos_api.dtos.ProdutosDto;

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
@Entity
@Table(name = "produto")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "quantidade", nullable = false, length = 10)
	private BigDecimal quantidade;
	
	@Column(name = "valor", nullable = false, length = 10)
	private BigDecimal valor;
	
	public static Produto create(ProdutosDto produtoDto) {
		return new ModelMapper().map(produtoDto, Produto.class);
	}
}
