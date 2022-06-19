package br.com.controle_orcamento_familiar.desafio_back_end_1edicao.service;

import br.com.controle_orcamento_familiar.desafio_back_end_1edicao.dto.ReceitaDTO;
import br.com.controle_orcamento_familiar.desafio_back_end_1edicao.exception.ReceitaDuplicadaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private ReceitaService service;

    @Test
    public void deveCriarUmaReceita(){
        ReceitaDTO receitaDTO = new ReceitaDTO();
        receitaDTO.setData(LocalDate.now());
        receitaDTO.setDescricao("conta de agua");
        receitaDTO.setValor(new BigDecimal("100.00"));
        ReceitaDTO dto = service.novaReceita(receitaDTO);
        Assertions.assertNotNull(dto.getData());
        Assertions.assertNotNull(dto.getValor());
        Assertions.assertNotNull(dto.getDescricao());
    }

    @Test
    public void naoDeveRepetirReceitaComUmaDescricaoExistenteNoMesmoMes(){
        ReceitaDTO receitaDTO = new ReceitaDTO();
        receitaDTO.setData(LocalDate.now());
        receitaDTO.setDescricao("conta de luz");
        receitaDTO.setValor(new BigDecimal("150.00"));
        service.novaReceita(receitaDTO);

        Assertions.assertThrows(ReceitaDuplicadaException.class,() -> service.novaReceita(receitaDTO));
    }
}
