package com.empresa.gerenciador_vales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.gerenciador_vales.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
