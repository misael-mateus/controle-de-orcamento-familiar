package br.com.controle_orcamento_familiar.desafio_back_end_1edicao.controller;

import br.com.controle_orcamento_familiar.desafio_back_end_1edicao.dto.ReceitaDTO;
import br.com.controle_orcamento_familiar.desafio_back_end_1edicao.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService service;

    /**
     * PostMapping
     * public ResponseEntity<ReceitaDTO> novaReceita(@Valid @RequestBody ReceitaDTO dto, UriComponentsBuilder uriBuilder) {
     * ReceitaDTO receitaCadastrada = this.service.novaReceita(dto);
     * Long idDaReceita = this.service.buscarId(receitaCadastrada);
     * <p>
     * URI endereco = uriBuilder.path("/receitas/{id}").buildAndExpand(idDaReceita).toUri();
     * return ResponseEntity.created(endereco).body(receitaCadastrada);
     * }
     */

    @PostMapping
    public ResponseEntity<ReceitaDTO> novaReceita(@RequestBody ReceitaDTO dto) {
        this.service.novaReceita(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Page<ReceitaDTO>> buscarTodasReceitas(Pageable pageable) {
        Page<ReceitaDTO> response = this.service.buscarTodasReceitas(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaDTO> buscarPorId(@PathVariable Long id){
        ReceitaDTO dto = this.service.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReceitaDTO> deletarPorId(@PathVariable Long id){
        this.service.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitaDTO> atualizarPorId(@PathVariable Long id,@RequestBody ReceitaDTO dto){
        ReceitaDTO receitaDTO = this.service.atualizarPorId(id,dto);
        return ResponseEntity.ok(receitaDTO);
    }
}
