package br.com.controle_orcamento_familiar.desafio_back_end_1edicao.service;

import br.com.controle_orcamento_familiar.desafio_back_end_1edicao.dto.ReceitaDTO;
import br.com.controle_orcamento_familiar.desafio_back_end_1edicao.exception.ReceitaDuplicadaException;
import br.com.controle_orcamento_familiar.desafio_back_end_1edicao.model.Receita;
import br.com.controle_orcamento_familiar.desafio_back_end_1edicao.repository.ReceitaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository repository;

    @Autowired
    private ModelMapper mapper;

    public ReceitaDTO novaReceita(ReceitaDTO dto) {
        Receita receita = mapper.map(dto,Receita.class);
        if (verificaDuplicidade(receita)) {
            throw new ReceitaDuplicadaException();
        }
        return mapper.map(this.repository.save(receita),ReceitaDTO.class);
    }

    public Page<ReceitaDTO> buscarTodasReceitas(Pageable pageable) {
        return this.repository.findAll(pageable)
                .map(receita -> mapper.map(receita,ReceitaDTO.class));
    }

    public Long buscarId(ReceitaDTO receitaCadastrada) {
        List<Receita> receitas = this.repository.findAll();

        for (Receita receita : receitas) {
            if (receita.getDescricao().equals(receitaCadastrada.getDescricao()))
                return receita.getId();
        }
        return 0L;
    }

    private boolean verificaDuplicidade(Receita receitaAComparar) {
        List<Receita> receitas = repository.findAll();
        for (Receita receita : receitas) {
            if (receita.getDescricao().equals(receitaAComparar.getDescricao()) && estaNoMesmoMes(receita, receitaAComparar)) {
                return true;
            }
        }
        return false;
    }

    private boolean estaNoMesmoMes(Receita receita, Receita receitaAComparar) {
        return receita.getData().getMonth().equals(receitaAComparar.getData().getMonth());
    }

}
