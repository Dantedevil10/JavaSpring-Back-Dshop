package dev.dante.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dev.dante.usuarios.dto.MensagemRequest;
import dev.dante.usuarios.models.Mensagens;
import dev.dante.usuarios.repository.MensagensRepository;
import dev.dante.usuarios.services.MensagensService;

@RestController
@RequestMapping("/mensagens")
public class MensagensController {
    @Autowired
    private MensagensService mensagensService;
    @Autowired
    private MensagensRepository menRepo;

    @GetMapping
    public List<Mensagens> listaMensagens(){
        return menRepo.findAll();
    }

    @PostMapping("/enviar")
    public MensagemRequest enviarMensagem(@RequestBody MensagemRequest mensagemRequest) {
        return mensagensService.enviarMensagem(
            mensagemRequest.getRemetenteId(),
            mensagemRequest.getDestinatarioId(),
            mensagemRequest.getConteudo()
        );
    }
}
