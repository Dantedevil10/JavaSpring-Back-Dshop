package dev.dante.usuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.dante.usuarios.models.Usuarios;
import dev.dante.usuarios.repository.MensagensRepository;
import dev.dante.usuarios.repository.UsuariosRepository;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private MensagensRepository mensagensUsuariosRepository;

    public Usuarios criarUsuario(String nome,String email,Boolean adm){

        //Verificação Email e NomeDeUsuario
        if(usuariosRepository.existsByEmail(email)){
            throw new RuntimeException("Email já cadastrado. Escolha outro email.");
        }
        if(usuariosRepository.existsByNome(nome)){
            throw new RuntimeException("Nome De Usuario já Existe. Escolha outro Nome.");
        }

        //Criação De Usuario
        Usuarios usuario = new Usuarios();
        usuario.setAdm(adm);
        usuario.setNome(nome);
        usuario.setEmail(email);
        return usuariosRepository.save(usuario);
    }

    public Usuarios editarUsuario(Long id , String nome , String email , Boolean adm){
        //Busca Usuario Pelo Id
        Usuarios usuario = usuariosRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado para o ID: " + id));

        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setAdm(adm);
        
        return usuariosRepository.save(usuario);
    }

    public Usuarios deletarUsuario(Long id){
        // Verifica se o usuário existe
        Usuarios usuario = usuariosRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado para o ID: " + id));

        // Excluir todas as mensagens associadas ao usuário
        mensagensUsuariosRepository.deleteByUsuario(usuario);

        usuariosRepository.delete(usuario);
        return usuario;

    }
    
}
