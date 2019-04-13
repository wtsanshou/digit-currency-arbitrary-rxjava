package ie.wtsanshou.digitcurrencyarbitraryrxjava.service;

import ie.wtsanshou.digitcurrencyarbitraryrxjava.model.CryptoCompareResponse;
import ie.wtsanshou.digitcurrencyarbitraryrxjava.model.CurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;

import java.net.URI;

@Service
public class CryptoCompareService implements DigitalCurrencyApiService {

    @Autowired
    private WebClient webClient;

    public Mono<CurrencyResponse> getCryptoBuyPrice(String coinName, String currency) {

        final URI uri = new DefaultUriBuilderFactory().builder().scheme("https").host("min-api.cryptocompare.com").path("/data/pricemulti")
                .queryParam("fsyms", coinName)
                .queryParam("tsyms", currency)
                .queryParam("api_key", "4d45bef642cf8f9fe0ddf38e79a34252eb2eacca53b9c990728c57af0d05c3b1")
                .build();

        return webClient
                .get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(CryptoCompareResponse.class));
    }

    @Override
    public Mono<CurrencyResponse> getCryptoSellPrice(String coinName, String currency) {
        return null;
    }

}
