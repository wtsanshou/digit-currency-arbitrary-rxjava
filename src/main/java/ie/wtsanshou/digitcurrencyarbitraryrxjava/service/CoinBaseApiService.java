package ie.wtsanshou.digitcurrencyarbitraryrxjava.service;

import ie.wtsanshou.digitcurrencyarbitraryrxjava.model.CoinBaseResponse;
import ie.wtsanshou.digitcurrencyarbitraryrxjava.model.CurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CoinBaseApiService implements DigitalCurrencyApiService {

    @Autowired
    private WebClient webClient;

    @Override
    public Mono<CurrencyResponse> getCryptoBuyPrice(String coinName, String currency) {
        return webClient
                .get()
                .uri("https://api.coinbase.com/v2/prices/{cryptoName}/buy", coinName+currency)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(CoinBaseResponse.class));
    }

    @Override
    public Mono<CurrencyResponse> getCryptoSellPrice(String coinName, String currency) {
        return webClient
                .get()
                .uri("https://api.coinbase.com/v2/prices/{cryptoName}/sell", coinName+currency)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(CoinBaseResponse.class));
    }
}
