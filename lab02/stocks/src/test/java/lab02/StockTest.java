package lab02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import lab02.Stock;

public class StockTest {

    private static Stock sample;

    @BeforeAll
    public static void setUp(){
        sample = new Stock("Junit inc.",69);
    }

    @DisplayName("Check negative stock quantities")
    @Test
    public void checkNegativeStockQuantities(){
        assertThrows(IllegalArgumentException.class, () -> sample.setQuantity(-1) );
    }

}
