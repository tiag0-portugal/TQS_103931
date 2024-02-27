package geocoding;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import geocoding.Address;
import geocoding.ISimpleHttpClient;

public class AddressResolverServiceTest {

    private ISimpleHttpClient ishc;
    private AddressResolverService sample;

    @BeforeEach
    public void setUp(){

        this.ishc = Mockito.mock(ISimpleHttpClient.class);
        this.sample = new AddressResolverService(ishc);

    };

    @DisplayName("Find Address Location")
    @Test 
    public void findAddress() {


        String json = "{\n" +
        "  \"info\": {\n" +
        "    \"statuscode\": 0,\n" +
        "    \"copyright\": {\n" +
        "      \"text\": \"© 2024 MapQuest, Inc.\",\n" +
        "      \"imageUrl\": \"https://api.mqcdn.com/res/mqlogo.gif\",\n" +
        "      \"imageAltText\": \"© 2024 MapQuest, Inc.\"\n" +
        "    },\n" +
        "    \"messages\": []\n" +
        "  },\n" +
        "  \"options\": {\n" +
        "    \"maxResults\": 1,\n" +
        "    \"thumbMaps\": true,\n" +
        "    \"ignoreLatLngInput\": false\n" +
        "  },\n" +
        "  \"results\": [\n" +
        "    {\n" +
        "      \"providedLocation\": {\n" +
        "        \"latLng\": {\n" +
        "          \"lat\": 30.333472,\n" +
        "          \"lng\": -81.470448\n" +
        "        }\n" +
        "      },\n" +
        "      \"locations\": [\n" +
        "        {\n" +
        "          \"street\": \"12714 Ashley Melisse Blvd\",\n" +
        "          \"adminArea6\": \"\",\n" +
        "          \"adminArea6Type\": \"Neighborhood\",\n" +
        "          \"adminArea5\": \"Jacksonville\",\n" +
        "          \"adminArea5Type\": \"City\",\n" +
        "          \"adminArea4\": \"Duval\",\n" +
        "          \"adminArea4Type\": \"County\",\n" +
        "          \"adminArea3\": \"FL\",\n" +
        "          \"adminArea3Type\": \"State\",\n" +
        "          \"adminArea1\": \"US\",\n" +
        "          \"adminArea1Type\": \"Country\",\n" +
        "          \"postalCode\": \"32225\",\n" +
        "          \"geocodeQualityCode\": \"L1AAA\",\n" +
        "          \"geocodeQuality\": \"ADDRESS\",\n" +
        "          \"dragPoint\": false,\n" +
        "          \"sideOfStreet\": \"R\",\n" +
        "          \"linkId\": \"0\",\n" +
        "          \"unknownInput\": \"\",\n" +
        "          \"type\": \"s\",\n" +
        "          \"latLng\": {\n" +
        "            \"lat\": 30.33472,\n" +
        "            \"lng\": -81.470448\n" +
        "          },\n" +
        "          \"displayLatLng\": {\n" +
        "            \"lat\": 30.333472,\n" +
        "            \"lng\": -81.470448\n" +
        "          },\n" +
        "          \"mapUrl\": \"https://www.mapquestapi.com/staticmap/v4/getmap?key=KEY&type=map&size=225,160&pois=purple-1,30.3334721,-81.4704483,0,0,|&center=30.3334721,-81.4704483&zoom=15&rand=-553163060\",\n" +
        "          \"nearestIntersection\": {\n" +
        "            \"streetDisplayName\": \"Posey Cir\",\n" +
        "            \"distanceMeters\": \"851755.1608527573\",\n" +
        "            \"latLng\": {\n" +
        "              \"longitude\": -87.523761,\n" +
        "              \"latitude\": 35.013434\n" +
        "            },\n" +
        "            \"label\": \"Danley Rd & Posey Cir\"\n" +
        "          },\n" +
        "          \"roadMetadata\": {\n" +
        "            \"speedLimitUnits\": \"mph\",\n" +
        "            \"tollRoad\": null,\n" +
        "            \"speedLimit\": 40\n" +
        "          }\n" +
        "        }\n" +
        "      ]\n" +
        "    }\n" +
        "  ]\n" +
        "}";

        Mockito.when(this.ishc.doHttpGet("https://www.mapquestapi.com/geocoding/v1/reverse?key=KEY&location=30.333472,-81.470448"))
            .thenReturn(json);

        // assertThat(this.sample.findAddressForLocation(30.333472,-81.470448),
        // equalTO(new Address("Jacksonville","32225","12714 Ashley Melisse Blvd","12714 Ashley Melisse Blvd")));

        assertEquals(this.sample.findAddressForLocation(30.333472,-81.470448),new Address("Jacksonville","32225","12714 Ashley Melisse Blvd","12714 Ashley Melisse Blvd"));
    }



    
    
}
