package me.veletron.desafioapi.repository;

import me.veletron.desafioapi.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
