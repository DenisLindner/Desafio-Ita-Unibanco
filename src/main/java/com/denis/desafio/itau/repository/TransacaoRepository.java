package com.denis.desafio.itau.repository;


import com.denis.desafio.itau.model.TransacaoEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TransacaoRepository {

    private ArrayList<TransacaoEntity> transacoes =  new ArrayList<>();

    public void save(TransacaoEntity transacao){
        transacoes.add(transacao);
    }
}
