package dev.dante.usuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.dante.usuarios.dto.ProdutosRequest;
import dev.dante.usuarios.models.Produtos;
import dev.dante.usuarios.models.Usuarios;
import dev.dante.usuarios.repository.ProdutosRepository;
import dev.dante.usuarios.repository.UsuariosRepository;

@Service
public class ProdutosService {
    
    @Autowired
    private ProdutosRepository pRepository;
    @Autowired
    private UsuariosRepository uRepo;

    public ProdutosRequest criarNovoProduto(String titulo,String descricao,Long UserId){
        Usuarios User = uRepo.findById(UserId).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        Produtos produto = new Produtos();
        produto.setTitulo(titulo);
        produto.setDescricao(descricao);
        produto.setUsuario(User);

        Produtos pSalvo =  pRepository.save(produto);

        return new ProdutosRequest(pSalvo.getTitulo(), pSalvo.getDescricao(),pSalvo.getUsuario().getId());
    }

}
