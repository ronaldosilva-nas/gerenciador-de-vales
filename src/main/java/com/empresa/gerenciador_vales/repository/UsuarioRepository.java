package com.empresa.gerenciador_vales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.gerenciador_vales.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);

}
