package br.com.controle_orcamento_familiar.desafio_back_end_1edicao.dto;

import br.com.controle_orcamento_familiar.desafio_back_end_1edicao.model.Receita;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReceitaDTO extends FinancasDTO{

    public ReceitaDTO(Receita receita){
        super.setData(receita.getData());
        super.setDescricao(receita.getDescricao());
        super.setValor(receita.getValor());
    }

}
