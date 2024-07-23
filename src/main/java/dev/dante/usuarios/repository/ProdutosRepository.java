package dev.dante.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.dante.usuarios.models.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos ,Long>{


    
}
