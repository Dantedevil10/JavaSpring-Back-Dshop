package dev.dante.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.dante.usuarios.models.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios,Long> {
    boolean existsByEmail(String email);
    boolean existsByNome(String nome);
}