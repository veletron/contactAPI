package me.veletron.desafioapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContatoNotFoundException extends Exception {

    public ContatoNotFoundException(Long contato_id) {
        super("Contato não encontrado com o ID " + contato_id);
    }
}
