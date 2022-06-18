package br.com.controle_orcamento_familiar.desafio_back_end_1edicao.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public abstract class FinancasDTO {
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
}
