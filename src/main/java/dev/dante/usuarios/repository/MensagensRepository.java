package dev.dante.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.dante.usuarios.models.Mensagens;
import dev.dante.usuarios.models.Usuarios;
import jakarta.transaction.Transactional;

@Repository
public interface MensagensRepository extends JpaRepository<Mensagens, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Mensagens m WHERE m.remetente = :usuario OR m.destinatario = :usuario")
    void deleteByUsuario(Usuarios usuario);
}
