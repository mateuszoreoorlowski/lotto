package spring.lotto.domain.numberreceiver.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
public record InputNumberResultDto(
        String ticketId,
        LocalDateTime drawDate,
        String message,
        Set<Integer> numberFromUser) {
}
