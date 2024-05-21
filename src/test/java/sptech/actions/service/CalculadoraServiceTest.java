package sptech.actions.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraServiceTest {
    public CalculadoraService calculadoraService = new CalculadoraService();

    @Test
    @DisplayName("Quando acionado com 10 e 2, então deve retornar 5")
    public void testDividir(){
        double a = 10;
        double b = 2;
        double esperado =  5;

        double resultado = calculadoraService.dividir(a,b);

        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Quando acionado com 10 e 0, então deve lançar uma exceção")
    public void testDividirPorZero(){
        double a = 10;
        double b = 0;
        var expectedMessage =  "400 BAD_REQUEST \"Não é possível dividir por zero\"";

        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class, () -> {
                    calculadoraService.dividir(a,b);
                }
        );

        assertEquals(expectedMessage, exception.getMessage());
    }
}