package br.com.controle_orcamento_familiar.desafio_back_end_1edicao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public abstract class Financas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotNull
    private String descricao;
    @NotNull
    @Column
    private BigDecimal valor;
    @NotNull
    @Column
    private LocalDate data;

}
