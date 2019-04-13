package ie.wtsanshou.digitcurrencyarbitraryrxjava.cmd;

import ie.wtsanshou.digitcurrencyarbitraryrxjava.observer.CoinBasePriceObserver;
import ie.wtsanshou.digitcurrencyarbitraryrxjava.observer.CryptoComparePriceObserver;
import ie.wtsanshou.digitcurrencyarbitraryrxjava.service.CoinBaseApiService;
import ie.wtsanshou.digitcurrencyarbitraryrxjava.service.CryptoCompareService;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CmdLineUi implements CommandLineRunner {

    @Autowired
    private CoinBaseApiService coinBaseApiService;

    @Autowired
    private CryptoCompareService cryptoCompareApiService;

    private final int INTERVAL = 10;
    private final TimeUnit SECOND = TimeUnit.SECONDS;

    @Override
    public void run(String... args){


        System.out.println("Starting receive digit currency prices!");

        Observable.interval(INTERVAL, SECOND)
                .map(tick -> coinBaseApiService.getCryptoBuyPrice("BTC-", "USD"))
                .subscribe(new CoinBasePriceObserver("Buy"));

        Observable.interval(INTERVAL, SECOND)
                .map(tick -> coinBaseApiService.getCryptoSellPrice("BTC-", "USD"))
                .subscribe(new CoinBasePriceObserver("Sell"));

        Observable.interval(INTERVAL, SECOND)
                .map(tick -> cryptoCompareApiService.getCryptoBuyPrice("BTC", "USD"))
                .subscribe(new CryptoComparePriceObserver());

    }
}
