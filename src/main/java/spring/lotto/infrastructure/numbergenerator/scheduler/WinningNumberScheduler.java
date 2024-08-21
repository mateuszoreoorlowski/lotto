package spring.lotto.infrastructure.numbergenerator.scheduler;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import spring.lotto.domain.numbergenerator.NumberGeneratorFacade;


@Component
@Log4j2
public class WinningNumberScheduler {


    private final NumberGeneratorFacade numberGeneratorFacade;

    public WinningNumberScheduler(NumberGeneratorFacade numberGeneratorFacade) {
        this.numberGeneratorFacade = numberGeneratorFacade;
    }

    @Scheduled(cron = "${winning.number.scheduler}")
    public void generate() {
        log.info("Generating winning numbers");
        numberGeneratorFacade.generateWinningNumbers();
    }
}
