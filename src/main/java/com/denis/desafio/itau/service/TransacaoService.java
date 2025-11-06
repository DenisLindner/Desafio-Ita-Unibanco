package com.denis.desafio.itau.service;

import com.denis.desafio.itau.exception.UnprocessableEntityException;
import com.denis.desafio.itau.model.EstatisticaResponse;
import com.denis.desafio.itau.model.TransacaoEntity;
import com.denis.desafio.itau.model.TransacaoRequest;
import com.denis.desafio.itau.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class TransacaoService {

    private TransacaoRepository transacaoRepository;

    public void save(TransacaoRequest data){
        if (data.valor() > 0){
            transacaoRepository.save(new TransacaoEntity(data.valor(), OffsetDateTime.now()));
        } else {
            throw new UnprocessableEntityException();
        }
    }

    public void deleteAll(){
        transacaoRepository.deleteAll();
    }

    public EstatisticaResponse getEstatisticas(){
        return transacaoRepository.getEstatisticas();
    }
}
