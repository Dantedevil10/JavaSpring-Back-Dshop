package dev.dante.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dante.usuarios.dto.ProdutosRequest;
import dev.dante.usuarios.models.Produtos;
import dev.dante.usuarios.models.Usuarios;
import dev.dante.usuarios.repository.ProdutosRepository;
import dev.dante.usuarios.services.ProdutosService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosService pService;
    @Autowired
    private ProdutosRepository pRepo;

    //GETS
    @GetMapping
    public List<Produtos> listaProdutos(){
        return pRepo.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produtos> findbyid(@PathVariable Long id){
        
        return pRepo.findById(id)
        .map(recordFound -> ResponseEntity.ok().body(recordFound))
        .orElse(ResponseEntity.notFound().build());
    }

    //POST
    @PostMapping("/criarProd")
    public ProdutosRequest CriarNovoProduto(@RequestBody ProdutosRequest pRequest) {
       return pService.criarNovoProduto(pRequest.getDescricao(),pRequest.getTitulo(),pRequest.getUsuario());
    }
    
    
}
