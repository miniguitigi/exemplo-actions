package com.example.exemplo_actions.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.AssertionErrors;
import org.springframework.web.server.ResponseStatusException;

public class CalculadoraServiceTeste {
    @Test
    @DisplayName("Quando acionado com 10 e 2, então deve retornar 5")
    public void testDividir(){
        CalculadoraService calculadoraService = new CalculadoraService();
        double a = 10;
        double b = 2;
        double esperado = 5;

        double resultado = calculadoraService.dividir(a,b);

        Assertions.assertEquals(esperado, resultado);


    }


    @Test
    @DisplayName("Quando acionado com 10 e 0, então deve lançar uma exceção")
    public void testDividirPorZero(){
        CalculadoraService calculadoraService = new CalculadoraService();
        double a = 10;
        double b = 0;
        var expectedMessage = "400 bad request\" divisão por zero não permitida\"";

        ResponseStatusException exception = Assertions.assertThrows(
                ResponseStatusException.class, () -> {
                    calculadoraService.dividir(a,b);
                });

        Assertions.assertEquals(expectedMessage,exception.getMessage());

    }
}
