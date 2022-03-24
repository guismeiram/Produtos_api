package com.produtos_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;

import com.produtos_api.dtos.ProdutosDto;
import com.produtos_api.services.ProdutosService;


@RestController
@RequestMapping("/produto")
public class ProdutosController {

	private final ProdutosService produtoService;
	
	
	@Autowired
	public ProdutosController(ProdutosService produtoService) {
		this.produtoService = produtoService;
	}


	@PostMapping(produces = {"application/json","application/xml","application/x-yaml"}, 
		     consumes = {"application/json","application/xml","application/x-yaml"})
public ProdutosDto create(@RequestBody ProdutosDto produtosDto) {
	ProdutosDto proDto = produtoService.create(produtosDto);
	proDto.add(linkTo(methodOn(ProdutosController.class).findById(proDto.getId())).withSelfRel());
	return proDto;
	}
	
	
	@GetMapping(value = "/{id}", produces = {"application/json","application/xml","application/x-yaml"})
	public ProdutosDto findById(@PathVariable("id")  Long id) {
		ProdutosDto produtoVO = produtoService.findById(id);
		produtoVO.add(linkTo(methodOn(ProdutosController.class).findById(id)).withSelfRel());
		return produtoVO;
	}
}
