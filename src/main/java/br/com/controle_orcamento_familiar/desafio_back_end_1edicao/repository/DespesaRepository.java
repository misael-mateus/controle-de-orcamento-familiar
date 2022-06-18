package br.com.controle_orcamento_familiar.desafio_back_end_1edicao.repository;

import br.com.controle_orcamento_familiar.desafio_back_end_1edicao.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa,Long> {
}
