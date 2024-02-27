package geocoding;


public class Address {

    public String city;
    public String zip;
    public String houseNumber;
    public String road;


    public Address(String city,String zip,String houseNumber,String road){

        this.city = city;
        this.zip = zip;
        this.houseNumber = houseNumber;
        this.road = road;

    }

    @Override
    public String toString(){
        return String.format("%s %s %s %s",city,zip,houseNumber,road);
    }

    public boolean equals(Address add){

        if( add.zip.equals(this.zip) && 
            add.city.equals(this.city) && 
            add.houseNumber.equals(this.houseNumber) && 
            add.road.equals(this.road)
        ){
            return true;
        }

        return false;
    }
}
