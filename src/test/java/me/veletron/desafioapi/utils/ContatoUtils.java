package me.veletron.desafioapi.utils;

import me.veletron.desafioapi.dto.request.ContatoDTO;
import me.veletron.desafioapi.entity.Contato;


public class ContatoUtils {

    private static final String contato_nome = "Vanderlei Tst";
    private static final String contato_email = "vanderlei@tst.me";
    private static final String contato_celular = "065999932222";
    private static final String contato_telefone = "06533335555";

    public static ContatoDTO createFakeDTO() {
        return ContatoDTO.builder()
                .contato_nome(contato_nome)
                .contato_email(contato_email)
                .contato_celular(contato_celular)
                .contato_telefone(contato_telefone)
                .build();
    }

    public static Contato createFakeEntity() {
        return Contato.builder()
                .contato_nome(contato_nome)
                .contato_email(contato_email)
                .contato_celular(contato_celular)
                .contato_telefone(contato_telefone)
                .build();
    }
}
