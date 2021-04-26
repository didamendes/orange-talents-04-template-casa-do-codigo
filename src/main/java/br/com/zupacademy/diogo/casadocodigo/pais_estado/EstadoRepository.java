package br.com.zupacademy.diogo.casadocodigo.pais_estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Query(" SELECT COUNT(e) FROM Estado e INNER JOIN e.pais p WHERE lower(e.nome) = lower(:nome) AND p.id = :idPais  ")
    Long estadoExisteNoPais(@Param("nome") String nome, @Param("idPais") Long idPais);

}
