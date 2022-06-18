package br.com.controle_orcamento_familiar.desafio_back_end_1edicao.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracoes {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
