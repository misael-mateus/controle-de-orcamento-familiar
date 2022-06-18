package br.com.controle_orcamento_familiar.desafio_back_end_1edicao.repository;

import br.com.controle_orcamento_familiar.desafio_back_end_1edicao.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita,Long> {
}
