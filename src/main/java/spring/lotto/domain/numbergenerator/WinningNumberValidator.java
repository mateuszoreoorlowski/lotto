package spring.lotto.domain.numbergenerator;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
class WinningNumberValidator {

    private final int LOWER_BAND = 0;
    private final int UPPER_BAND = 49;

    public Set<Integer> validate(Set<Integer> winningNumbers) {
        if (outOfRange(winningNumbers)) {
            throw new IllegalStateException("Number out of range!");
        }
        return winningNumbers;
    }

    private boolean outOfRange(Set<Integer> winningNumbers) {
        return winningNumbers.stream()
                .anyMatch(number -> number < LOWER_BAND || number > UPPER_BAND);
    }
}