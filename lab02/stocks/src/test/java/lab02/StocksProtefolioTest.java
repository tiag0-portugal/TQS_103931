package lab02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import lab02.Stock;
import lab02.StocksProtefolio;


public class StocksProtefolioTest {


    private  IStockmarketService stmkt_sample;
    private  StocksProtefolio sample; 

    @BeforeEach
    public  void setUp() {

       stmkt_sample = Mockito.mock(IStockmarketService.class);
       sample = new StocksProtefolio(stmkt_sample);

    }

    @DisplayName("Total test")
    @Test
    public void totalTest() {

        Mockito.when(stmkt_sample.lookUpPrice("amd")).thenReturn(50.0);
        Mockito.when(stmkt_sample.lookUpPrice("nvda")).thenReturn(100.0);
        Mockito.when(stmkt_sample.lookUpPrice("intel")).thenReturn(10.0);

        sample.addStock(new Stock("amd",7));
        sample.addStock(new Stock("nvda",2));
        sample.addStock(new Stock("intel",5));

        assertEquals(7*50.0 + 100*2 + 10.0*5,sample.totalValue());

    }


    @DisplayName("No duplicates")
    @Test
    public void noDuplicates(){

        sample.addStock(new Stock("amd",7));
        sample.addStock(new Stock("amd",2));

        assertThat(
            sample.getStocks().stream()
            .filter( st -> st.getLabel().equals("amd") )
            .count(), equalTo(1L));

        assertEquals(sample.getStocks().get(0).getQuantity(), 9); 

    }

    
}
