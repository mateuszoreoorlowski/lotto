package spring.lotto.domain.numberreceiver.dto;

import java.util.Set;

public record RequestNumberDto(
        Set<Integer> numbersFromUser) {
}
