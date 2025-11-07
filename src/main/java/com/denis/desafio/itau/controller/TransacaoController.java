package com.denis.desafio.itau.controller;

import com.denis.desafio.itau.model.EstatisticaResponse;
import com.denis.desafio.itau.model.TransacaoRequest;
import com.denis.desafio.itau.service.TransacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TransacaoController {

    private TransacaoService transacaoService;

    @PostMapping("/transacao")
    public ResponseEntity<Void> save(@RequestBody @Valid TransacaoRequest transacaoRequest){
        transacaoService.save(transacaoRequest);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<Void> deleteAll(){
        transacaoService.deleteAll();
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/estatistica")
    public ResponseEntity<EstatisticaResponse> getEstatisticas(){
        return ResponseEntity.status(200).body(transacaoService.getEstatisticas());
    }

    @PostMapping("/mudar-tempo")
    public ResponseEntity<String> mudarTempo(@RequestParam int seconds){
        return ResponseEntity.status(201).body(transacaoService.mudarTempo(seconds));
    }
}
