package dev.dante.usuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.dante.usuarios.dto.MensagemRequest;
import dev.dante.usuarios.models.Mensagens;
import dev.dante.usuarios.models.Usuarios;
import dev.dante.usuarios.repository.MensagensRepository;
import dev.dante.usuarios.repository.UsuariosRepository;

import java.time.LocalDateTime;

@Service
public class MensagensService {
    @Autowired
    private MensagensRepository mensagensRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    public MensagemRequest enviarMensagem(Long remetenteId, Long destinatarioId, String conteudo) {
        Usuarios remetente = usuariosRepository.findById(remetenteId).orElseThrow(() -> new RuntimeException("Remetente não encontrado"));
        Usuarios destinatario = usuariosRepository.findById(destinatarioId).orElseThrow(() -> new RuntimeException("Destinatario não encontrado"));

        Mensagens mensagem = new Mensagens();
        mensagem.setRemetente(remetente);
        mensagem.setDestinatario(destinatario);
        mensagem.setConteudo(conteudo);
        mensagem.setDataEnvio(LocalDateTime.now());

        Mensagens mensagemSalva = mensagensRepository.save(mensagem);

        return new MensagemRequest(
            mensagemSalva.getId(),
            mensagemSalva.getRemetente().getId(),
            mensagemSalva.getDestinatario().getId(),
            mensagemSalva.getConteudo(),
            mensagemSalva.getDataEnvio()
        );
    }
}
