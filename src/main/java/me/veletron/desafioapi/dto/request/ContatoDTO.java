package me.veletron.desafioapi.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO {

    private long contato_id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String contato_nome;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String contato_email;

    @NotEmpty
    @Size(min = 11, max = 14)
    private String contato_celular;

    @Size(min = 10, max = 14)
    private String contato_telefone;
    private char contato_sn_favorito;
    private char contato_sn_ativo;
    private LocalDateTime contato_dh_cad;
}
