package geocoding;

import geocoding.Address;

public interface ISimpleHttpClient {

    public String doHttpGet(String uri);
    
}

