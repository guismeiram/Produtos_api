package com.produtos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos_api.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	Produto findById(long id);

}