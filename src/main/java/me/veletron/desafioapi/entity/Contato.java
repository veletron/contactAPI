package me.veletron.desafioapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contato_id;
    @Column(nullable = false)
    private String contato_nome;
    private String contato_email;
    @Column(nullable = false, unique = true)
    private String contato_celular;
    private String contato_telefone;
    private char contato_sn_favorito;
    private char contato_sn_ativo;
    private LocalDateTime contato_dh_cad;

}
