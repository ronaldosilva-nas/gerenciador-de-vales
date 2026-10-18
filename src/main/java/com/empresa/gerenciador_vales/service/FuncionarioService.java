package com.empresa.gerenciador_vales.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow();
        return funcionario;
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {
        Funcionario existente = buscarPorId(id);
        existente.setNome(funcionario.getNome());
        existente.setCpf(funcionario.getCpf());
        existente.setSetor(funcionario.getSetor());
        existente.setTelefone(funcionario.getTelefone());
        existente.setEndereco(funcionario.getEndereco());
        Funcionario atualizado = funcionarioRepository.save(existente);
        return atualizado;
    }

    public void deletarFuncionario(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado.");
        }
        funcionarioRepository.deleteById(id);
    }

}
