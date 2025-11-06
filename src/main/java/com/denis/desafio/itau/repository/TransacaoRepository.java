package com.denis.desafio.itau.repository;


import com.denis.desafio.itau.model.EstatisticaResponse;
import com.denis.desafio.itau.model.TransacaoEntity;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TransacaoRepository {

    private ArrayList<TransacaoEntity> transacoes =  new ArrayList<>();

    public void save(TransacaoEntity transacao){
        transacoes.add(transacao);
    }

    public void deleteAll(){
        transacoes.clear();
    }

    public EstatisticaResponse getEstatisticas(){
        List<TransacaoEntity> lastMinute = transacoes.stream().filter(t -> Duration.between(t.getDataHora(), OffsetDateTime.now()).getSeconds() <= 60)
                .toList();
        if(lastMinute.isEmpty()){
            return new EstatisticaResponse(0,0,0,0,0);
        }

        DoubleSummaryStatistics ds = lastMinute.stream().collect(Collectors.summarizingDouble(TransacaoEntity::getValor));

        return new EstatisticaResponse(ds.getCount(), ds.getSum(), ds.getAverage(), ds.getMax(), ds.getMin());
    }
}
