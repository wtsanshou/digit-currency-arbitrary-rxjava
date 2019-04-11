package ie.wtsanshou.digitcurrencyarbitraryrxjava.observer;

import ie.wtsanshou.digitcurrencyarbitraryrxjava.model.CoinBaseResponse;
import io.reactivex.observers.DefaultObserver;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


public class ConsolePrintObserver extends DefaultObserver {
    @Override
    public void onNext(Object o) {
        Mono<CoinBaseResponse> responseMono = (Mono<CoinBaseResponse>) o;

        responseMono.subscribe(
                coinBaseResponse -> {
                    System.out.println(
                            "[" + LocalDateTime.now() + " "
                                    + coinBaseResponse.getData().getBase()
                                    + " Buy Price: $" + coinBaseResponse.getData().getAmount()
                                    + "" + coinBaseResponse.getData().getCurrency()
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
        System.out.println("Completed!");
    }
}
