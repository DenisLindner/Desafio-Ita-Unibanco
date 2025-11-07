package com.denis.desafio.itau.service;

import com.denis.desafio.itau.exception.UnprocessableEntityException;
import com.denis.desafio.itau.model.EstatisticaResponse;
import com.denis.desafio.itau.model.TransacaoEntity;
import com.denis.desafio.itau.model.TransacaoRequest;
import com.denis.desafio.itau.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private int segundos;

    @Autowired
    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.segundos = 60;
    }

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
        return transacaoRepository.getEstatisticas(this.segundos);
    }

    public String mudarTempo(int data){
        if (data <= 0){
            return "Não foi possível mudar o intervalo de tempo: Valor menor ou igual a 0";
        }
        this.segundos = data;
        return "Intervalo de tempo alterado com sucesso";
    }
}
