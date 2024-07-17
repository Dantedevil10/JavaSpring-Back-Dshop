package dev.dante.usuarios.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios_cadastrados")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15,nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Boolean adm;

    @OneToMany(mappedBy = "remetente")
    @JsonIgnoreProperties("remetente")
    private List<Mensagens> mensagensEnviadas;

    @OneToMany(mappedBy = "destinatario")
    @JsonIgnoreProperties("destinatario")
    private List<Mensagens> mensagensRecebidas;
    
}
