package com.empresa.gerenciador_vales.dto;

import java.time.LocalDateTime;

public record UsuarioResponseDTO(
    Long id, 
    String email, 
    String perfil, 
    Long funcionarioId,
    LocalDateTime dataCadastro) {

}
