package com.empresa.gerenciador_vales.service;

import org.springframework.stereotype.Service;

import com.empresa.gerenciador_vales.entity.Funcionario;
import com.empresa.gerenciador_vales.repository.FuncionarioRepository;

@Service 
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario salvar(Funcionario funcionario) {
        Funcionario salvo = funcionarioRepository.save(funcionario);
        return salvo;
    }

}
