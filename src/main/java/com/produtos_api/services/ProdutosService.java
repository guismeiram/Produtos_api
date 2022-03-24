package com.produtos_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos_api.dtos.ProdutosDto;
import com.produtos_api.exception.ResourceNotFoundException;
import com.produtos_api.models.Produto;
import com.produtos_api.repository.ProdutoRepository;


@Service
public class ProdutosService {
	
	private final ProdutoRepository produtoRepository;

	
	@Autowired
	public ProdutosService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}



	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	

	public Produto listaProdutoUnico(long id){
		return produtoRepository.findById(id);
	}
	

	public ProdutosDto create(ProdutosDto produtoDto) {
		ProdutosDto proDtoRetorno = ProdutosDto.create(produtoRepository.save(Produto.create(produtoDto)));
		return proDtoRetorno;
		
	}
	
	private ProdutosDto convertToProdutosDto(Produto produto) {
		return ProdutosDto.create(produto);
	}
	
	public ProdutosDto findById(Long id) {
		Produto entity = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return ProdutosDto.create(entity);
	}
	
	

	public void deletaProduto( Produto produto) {
		produtoRepository.delete(produto);
	}
	
	
	public Produto atualizaProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
}
