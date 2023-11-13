package me.veletron.desafioapi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.veletron.desafioapi.dto.request.ContatoDTO;
import me.veletron.desafioapi.dto.response.MessageResponseDTO;
import me.veletron.desafioapi.entity.Contato;
import me.veletron.desafioapi.exception.ContatoNotFoundException;
import me.veletron.desafioapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contato")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ContatoController {

    private ContatoService contatoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createContato(@RequestBody @Valid ContatoDTO contatoDTO) {
        return contatoService.createContato(contatoDTO);
    }

    @GetMapping
    public List<ContatoDTO> listAll() {
        return contatoService.listAll();
    }

    @GetMapping("/{contato_id}")
    public ContatoDTO findById(@PathVariable Long contato_id) throws ContatoNotFoundException {
        return contatoService.findById(contato_id);
    }

    @PutMapping("/{contato_id}")
    public MessageResponseDTO updateById(@PathVariable Long contato_id, @RequestBody @Valid ContatoDTO contatoDTO) throws ContatoNotFoundException {
        return contatoService.updateById(contato_id, contatoDTO);
    }

    @DeleteMapping("/{contato_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long contato_id) throws ContatoNotFoundException {
        contatoService.delete(contato_id);
    }

}