package ie.wtsanshou.digitcurrencyarbitraryrxjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/*
{
        "ETH": {
        "BTC": 0.03262,
        "USD": 165.91,
        "EUR": 146.69
        },
        "DASH": {
        "BTC": 0.02422,
        "USD": 123.25,
        "EUR": 108.49
        }
}
*/

@Data
public class CryptoCompareResponse implements CurrencyResponse{

    @JsonProperty("ETH")
    private COIN ETH;
    @JsonProperty("DASH")
    private COIN DASH;
    @JsonProperty("BTC")
    private COIN BTC;

    private COIN other;
    @Data
    public class COIN{
        @JsonProperty("BTC")
        private  double BTC;
        @JsonProperty("USD")
        private  double USD;
        @JsonProperty("EUR")
        private  double EUR;
    }
}
