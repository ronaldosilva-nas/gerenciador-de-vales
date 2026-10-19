package com.empresa.gerenciador_vales.exception;

public class FuncionarioNotFoundException extends RuntimeException{

    public FuncionarioNotFoundException(String mensagem) {
        super(mensagem);
    }

}
