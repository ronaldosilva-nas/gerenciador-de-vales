package com.empresa.gerenciador_vales.service;

import org.springframework.stereotype.Service;

import com.empresa.gerenciador_vales.entity.Usuario;
import com.empresa.gerenciador_vales.repository.UsuarioRepository;

@Service 
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
        Usuario salvo = usuarioRepository.save(usuario);
        return salvo;
    }

}
