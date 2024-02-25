package lab02;
import java.util.List;
import java.util.ArrayList;

public class StocksProtefolio {

    private IStockmarketService stmkt;
    private List<Stock> stocks;

    public StocksProtefolio(IStockmarketService stmkt){
        this.stmkt = stmkt;
        this.stocks = new ArrayList<Stock>();
    }


    public StocksProtefolio(IStockmarketService stmkt,List<Stock> stocks){
        this.stmkt = stmkt;
        this.stocks = stocks;
    }


    public void addStock(Stock st) {

        boolean stockAdded = false;

        for (Stock element : stocks) {
            if (element.getLabel().equals(st.getLabel())) {
                element.setQuantity(element.getQuantity() + st.getQuantity());
                stockAdded = true;
                break;
            }
        }

        if (!stockAdded) {
            stocks.add(st);
        }
    }

    public double totalValue(){

        return this.stocks.stream()
                .mapToDouble(st -> st.getQuantity()*this.stmkt.lookUpPrice(st.getLabel()))
                .sum();

    }
    
}
