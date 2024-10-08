package spring.lotto.domain.numberreceiver;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
class NumberValidator {

    public static final int MINIMAL_NUMBER_FROM_USER = 1;
    public static final int MAXIMAL_NUMBER_FROM_USER = 49;
    public static final int QUANTITY_OF_NUMBERS_FROM_USER = 6;

    List<ValidationResult> errors;

    List<ValidationResult> validate(Set<Integer> numbersFromUser) {
        errors = new LinkedList<>();
        if (!isNumbersSizeEqualSix(numbersFromUser)) {
            errors.add(ValidationResult.NOT_SIX_NUMBERS_GIVEN);
        }
        if (!isNumberInRange(numbersFromUser)) {
            errors.add(ValidationResult.NOT_IN_RANGE);
        }
        return errors;
    }

    String createResultMessage() {
        return this.errors
                .stream()
                .map(validationResult -> validationResult.info)
                .collect(Collectors.joining(","));
    }

    private boolean isNumbersSizeEqualSix(Set<Integer> numbersFromUser) {
        return numbersFromUser.size() == QUANTITY_OF_NUMBERS_FROM_USER;
    }

    boolean isNumberInRange(Set<Integer> numbersFromUser) {
        return numbersFromUser.stream()
                .allMatch(number -> number >= MINIMAL_NUMBER_FROM_USER && number <= MAXIMAL_NUMBER_FROM_USER);
    }
}
