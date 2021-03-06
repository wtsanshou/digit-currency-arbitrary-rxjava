package ie.wtsanshou.digitcurrencyarbitraryrxjava.model;

import lombok.Data;

@Data
public class CoinBaseResponse implements CurrencyResponse{

    private Data data;

    @lombok.Data
    public class Data {

        private String base;
        private String currency;
        private String amount;
    }
}
