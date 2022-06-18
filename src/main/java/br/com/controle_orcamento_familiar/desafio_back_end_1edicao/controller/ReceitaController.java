package br.com.controle_orcamento_familiar.desafio_back_end_1edicao.controller;

import br.com.controle_orcamento_familiar.desafio_back_end_1edicao.dto.ReceitaDTO;
import br.com.controle_orcamento_familiar.desafio_back_end_1edicao.model.Receita;
import br.com.controle_orcamento_familiar.desafio_back_end_1edicao.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService service;

    @PostMapping
    public ResponseEntity<ReceitaDTO> novaReceita(@Valid @RequestBody ReceitaDTO dto, UriComponentsBuilder uriBuilder) {
        ReceitaDTO receitaCadastrada = this.service.novaReceita(dto);
        Long idDaReceita = this.service.buscarId(receitaCadastrada);
        URI endereco = uriBuilder.path("/receitas/{id}").buildAndExpand(idDaReceita).toUri();
        return ResponseEntity.created(endereco).body(receitaCadastrada);
    }

    @GetMapping
    public List<ReceitaDTO> buscarTodasReceitas() {
        return this.service.buscarTodasReceitas();
    }

}
