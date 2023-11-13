package me.veletron.desafioapi.service;

import lombok.AllArgsConstructor;
import me.veletron.desafioapi.dto.request.ContatoDTO;
import me.veletron.desafioapi.dto.response.MessageResponseDTO;
import me.veletron.desafioapi.entity.Contato;
import me.veletron.desafioapi.exception.ContatoNotFoundException;
import me.veletron.desafioapi.mapper.ContatoMapper;
import me.veletron.desafioapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ContatoService {

    private ContatoRepository contatoRepository;

    private final ContatoMapper contatoMapper = ContatoMapper.INSTANCE;

    public MessageResponseDTO createContato(ContatoDTO contatoDTO) {
        Contato contatoToSave = contatoMapper.toModel(contatoDTO);

        Contato savedContato = contatoRepository.save(contatoToSave);
        return createMessageResponse(savedContato.getContato_id(), "Contato Cadastrado com ID ");
    }

    public List<ContatoDTO> listAll() {
        List<Contato> allPessoas = contatoRepository.findAll();
        return allPessoas.stream()
                .map(contatoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ContatoDTO findById(Long contato_id) throws ContatoNotFoundException {
        Contato contato = verifyIfExists(contato_id);
        return contatoMapper.toDTO(contato);

    }

    public void delete(Long contato_id) throws ContatoNotFoundException {
        verifyIfExists(contato_id);
        contatoRepository.deleteById(contato_id);
    }

    public MessageResponseDTO updateById(Long contato_id, ContatoDTO contatoDTO) throws ContatoNotFoundException {
        verifyIfExists(contato_id);
        Contato contatoToUpdate = contatoMapper.toModel(contatoDTO);
        Contato updateContato = contatoRepository.save(contatoToUpdate);
        return createMessageResponse(updateContato.getContato_id(), "Alterado contato com ID ");
    }

    private Contato verifyIfExists(Long contato_id) throws ContatoNotFoundException {
        return contatoRepository.findById(contato_id)
                .orElseThrow(() -> new ContatoNotFoundException(contato_id));
    }
    private static MessageResponseDTO createMessageResponse(Long contato_id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + contato_id)
                .build();
    }
}
