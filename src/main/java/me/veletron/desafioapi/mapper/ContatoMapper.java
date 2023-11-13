package me.veletron.desafioapi.mapper;

import me.veletron.desafioapi.dto.request.ContatoDTO;
import me.veletron.desafioapi.entity.Contato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContatoMapper {

    ContatoMapper INSTANCE = Mappers.getMapper(ContatoMapper.class);
    @Mapping(target = "contato_dh_cad", source = "contato_dh_cad", dateFormat = "dd-MM-yyyy")
    Contato toModel(ContatoDTO contatoDTO);

    ContatoDTO toDTO(Contato contato);
}
