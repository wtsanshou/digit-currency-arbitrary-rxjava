package ie.wtsanshou.digitcurrencyarbitraryrxjava.service;

import ie.wtsanshou.digitcurrencyarbitraryrxjava.model.CurrencyResponse;
import reactor.core.publisher.Mono;

public interface DigitalCurrencyApiService {
    Mono<CurrencyResponse> getCryptoBuyPrice(String coinName, String currency);

    Mono<CurrencyResponse> getCryptoSellPrice(String coinName, String currency);
}
