package ie.wtsanshou.digitcurrencyarbitraryrxjava.service;

import ie.wtsanshou.digitcurrencyarbitraryrxjava.model.CoinBaseResponse;
import reactor.core.publisher.Mono;

public interface CoinbaseService {
    Mono<CoinBaseResponse> getCryptoPtrice(String currencyName);
}
