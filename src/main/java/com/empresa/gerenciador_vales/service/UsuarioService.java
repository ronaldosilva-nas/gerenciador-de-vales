package com.empresa.gerenciador_vales.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.empresa.gerenciador_vales.entity.Funcionario;
import com.empresa.gerenciador_vales.entity.Usuario;
import com.empresa.gerenciador_vales.repository.FuncionarioRepository;
import com.empresa.gerenciador_vales.repository.UsuarioRepository;

@Service 
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          FuncionarioRepository funcionarioRepository,
                          PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Funcionario buscarFuncionarioPorId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));
        return funcionario;
    }

    public Usuario salvar(Usuario usuario) {
        Funcionario funcionario = buscarFuncionarioPorId(usuario.getFuncionario().getId());
        usuario.setFuncionario(funcionario);
        if(usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Este e-mail já está cadastrado.");
        }
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

}
