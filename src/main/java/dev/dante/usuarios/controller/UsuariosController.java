package dev.dante.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dante.usuarios.dto.UsuarioRequest;
import dev.dante.usuarios.models.Usuarios;
import dev.dante.usuarios.repository.MensagensRepository;
import dev.dante.usuarios.repository.UsuariosRepository;
import dev.dante.usuarios.services.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private MensagensRepository mensagensUsuariosRepository;

    //GET
    @GetMapping
    public List<Usuarios> listaUsers(){
        return usuariosRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> findbyid(@PathVariable Long id){
        
        return usuariosRepository.findById(id)
        .map(recordFound -> ResponseEntity.ok().body(recordFound))
        .orElse(ResponseEntity.notFound().build());
    }

    //POST
    @PostMapping("/criarUser")
    public Usuarios criarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return usuariosService.criarUsuario(usuarioRequest.getNome() ,usuarioRequest.getEmail(),usuarioRequest.getAdm());
    }

    //PUT
    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuarios> editarUsuario(@PathVariable Long id ,@RequestBody UsuarioRequest usuarioRequest){
        try{
            Usuarios updatedUsuario = usuariosService.editarUsuario(id, usuarioRequest.getNome(), 
            usuarioRequest.getEmail(), usuarioRequest.getAdm());

            return ResponseEntity.ok(updatedUsuario);
        }catch(RuntimeException e){
            // Soltar uma excessao se o usuario nao for encontrado ou essa caceta der problema
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE
    @DeleteMapping("/deletarUser/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
       
        try {
            usuariosService.deletarUsuario(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            // Soltar uma excessao se o usuario nao for encontrado ou essa caceta der problema
            return ResponseEntity.notFound().build();
        }
       
        
    }
    
}
