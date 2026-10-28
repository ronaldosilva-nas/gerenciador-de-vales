package com.empresa.gerenciador_vales.dto;

public record UsuarioRequestDTO(
    String email, 
    String senha, 
    String perfil, 
    Long funcionarioId) {
}
