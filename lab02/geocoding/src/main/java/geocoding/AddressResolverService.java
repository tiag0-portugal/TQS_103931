package geocoding;

import java.util.Optional;
import org.json.*;
import geocoding.Address;
import geocoding.ISimpleHttpClient;

public class AddressResolverService {

    private ISimpleHttpClient httpClient;

    public AddressResolverService(ISimpleHttpClient httpClient){
        this.httpClient = httpClient;
    }

    private String prepareUriForRemoteEndpoint(double x,double y){

        String uri = String.format("https://www.mapquestapi.com/geocoding/v1/reverse?key=KEY&location=%f,%f",x,y);
        return uri;
    }

    public Optional<Address> findAddressForLocation(double x, double y) {
        String uri = prepareUriForRemoteEndpoint(x, y);

        try {
            String response_string = httpClient.doHttpGet(uri);
            JSONObject response = new JSONObject(response_string);

            if (!response.has("results") || response.getJSONArray("results").isEmpty()) {
                System.err.println("No results found in the response.");
                return Optional.empty();
            }

            JSONArray results = response.getJSONArray("results");
            JSONObject firstResult = results.getJSONObject(0);

            if (!firstResult.has("locations") || firstResult.getJSONArray("locations").isEmpty()) {
                System.err.println("No locations found in the first result.");
                return Optional.empty();
            }

            JSONObject firstLocation = firstResult.getJSONArray("locations").getJSONObject(0);

            String city = null;
            String zip = null;
            String road = null;
            String houseNumber = null;

            if (!firstLocation.has("postalCode")) {
                throw new IllegalStateException("No zip found");
            } else {
                zip = firstLocation.getString("postalCode");
            }

            if (!firstLocation.has("adminArea5")) {
                throw new IllegalStateException("No city found");
            } else {
                city = firstLocation.getString("adminArea5");
            }

            if (firstLocation.has("street")) {
                houseNumber = firstLocation.getString("street");
                road = firstLocation.getString("street");
            }

            return Optional.of(new Address(city, zip, houseNumber, road));

        } catch (Exception e) {
            System.err.println(String.format("Error while finding address for %f,%f: %s", x, y, e.getMessage()));
            return Optional.empty();
        }
    }

}
