package geocoding;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import geocoding.Address;

public class AddressTest {

    private Address sample;

    @BeforeEach
    public void setUp(){

        sample = new Address("Aveiro","3888","9","Travessa da travessa");
    }
    
}
