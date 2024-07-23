package dev.dante.usuarios.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "mensagens_usuarios")
public class Mensagens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "remetente_id", nullable = false)
    @JsonIgnoreProperties({"mensagensEnviadas", "mensagensRecebidas","produtos","email"})
    private Usuarios remetente;

    @ManyToOne
    @JsonIgnoreProperties({"mensagensEnviadas", "mensagensRecebidas","produtos","email"})
    @JoinColumn(name = "destinatario_id", nullable = false)
    private Usuarios destinatario;

    @Column(nullable = false)
    private String conteudo;

    @Column(nullable = false)
    private LocalDateTime dataEnvio;
    
}
