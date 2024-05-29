package sptech.projetojpa6.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadorDescontosServicesTest {

    @Test
    @DisplayName("Salário até 2000 deveria ter 10% de desconto")
    void getDescontoInss() {
        var service = new CalculadorDescontosServices();
        var desconto = service.getDescontoInss(1000.0);

        assertEquals(100.0,desconto);
    }@Test
    @DisplayName("Salário ]2mil..4min] deveria ter 15% de desconto")
    void getDescontoInss3500() {
        var service = new CalculadorDescontosServices();
        var desconto = service.getDescontoInss(3500.00);

        assertEquals(525.0,desconto);
    }
}