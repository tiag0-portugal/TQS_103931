package lab02;

public class Stock {

    private String label;
    private Integer quantity;

    public String getLabel(){
        return this.label;
    };


    public Integer getQuantity(){
        return this.quantity;
    };

    public void setLabel(String label){
        this.label = label;
    };


    public void setQuantity(Integer quantity){

        if(quantity < 0){
            throw new IllegalArgumentException("Negative quantity");
        }

        this.quantity = quantity;

    };

    public Stock(String label,Integer quantity){
        setQuantity(quantity);
        setLabel(label);
    }

}
