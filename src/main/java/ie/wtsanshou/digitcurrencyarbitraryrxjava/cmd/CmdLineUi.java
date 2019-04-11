package ie.wtsanshou.digitcurrencyarbitraryrxjava.cmd;

import ie.wtsanshou.digitcurrencyarbitraryrxjava.observer.ConsolePrintObserver;
import ie.wtsanshou.digitcurrencyarbitraryrxjava.service.CoinbaseService;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CmdLineUi implements CommandLineRunner {

    @Autowired
    private CoinbaseService coinbaseService;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Starting receive digit currency prices!");

        Observable.interval(3000, TimeUnit.MILLISECONDS)
                .map(tick -> coinbaseService.getCryptoPtrice("BTC-USD"))
                .subscribe(new ConsolePrintObserver());

        Observable.interval(3000, TimeUnit.MILLISECONDS)
                .map(tick -> coinbaseService.getCryptoPtrice("ETH-USD"))
                .subscribe(new ConsolePrintObserver());

    }
}
