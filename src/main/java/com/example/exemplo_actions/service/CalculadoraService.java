package com.example.exemplo_actions.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CalculadoraService {
    public double dividir(double a, double b){
        if(b==0){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Divisão por zero não permitida");
        }
        return a/b;
    }
}
