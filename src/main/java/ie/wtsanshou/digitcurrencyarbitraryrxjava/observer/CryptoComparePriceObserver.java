package ie.wtsanshou.digitcurrencyarbitraryrxjava.observer;

import ie.wtsanshou.digitcurrencyarbitraryrxjava.model.CryptoCompareResponse;
import io.reactivex.observers.DefaultObserver;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class CryptoComparePriceObserver extends DefaultObserver {

    @Override
    public void onNext(Object o) {
        Mono<CryptoCompareResponse> responseMono = (Mono<CryptoCompareResponse>) o;

        responseMono.subscribe(
                cryptoCompareResponse -> {
                    System.out.println(
                            "[" + LocalDateTime.now() + " "
                                    + "BTC"
                                    + " CryptoCompare Buy Price: $" + cryptoCompareResponse.getBTC().getUSD()
                                    + "" + " USD"
                    );
                }
        );
    }

    @Override
    public void onError(Throwable e) {
        System.out.println("error = " + e);
    }

    @Override
    public void onComplete() {
        System.out.println("Crypto Compare Completed!");
    }
}
