package com.denis.desafio.itau.controller;

import com.denis.desafio.itau.model.TransacaoRequest;
import com.denis.desafio.itau.service.TransacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TransacaoController {

    private TransacaoService transacaoService;

    @PostMapping("/transacao")
    public ResponseEntity<Void> save(@RequestBody @Valid TransacaoRequest transacaoRequest){
        transacaoService.save(transacaoRequest);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("transacao")
    public ResponseEntity<Void> deleteAll(){
        transacaoService.deleteAll();
        return ResponseEntity.status(200).build();
    }
}
