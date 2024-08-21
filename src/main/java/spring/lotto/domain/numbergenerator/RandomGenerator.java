package spring.lotto.domain.numbergenerator;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
class RandomGenerator implements RandomNumberGenerable{
    private final int LOWER_BAND = 1;
    private final int UPPER_BAND = 49;

    private final int RANDOM_NUMBER_BOUND = (UPPER_BAND - LOWER_BAND) + 1;

    @Override
    public Set<Integer> genereteSixRandomNumbers() {
        Set<Integer> winningNumbers = new HashSet<>();
        while (isAmountofNumbersLowerThanSix(winningNumbers)) {
            int randomNumber = generateRandom();
            winningNumbers.add(randomNumber);
        }
        return winningNumbers;
    }

    private int generateRandom() {
        Random random = new SecureRandom();
        return random.nextInt(RANDOM_NUMBER_BOUND) + 1;
    }

    private boolean isAmountofNumbersLowerThanSix(Set<Integer> winningNumbers) {
        return winningNumbers.size() < 6;
    }

}