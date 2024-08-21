package spring.lotto.domain.resultannoucer;

import spring.lotto.domain.resultannoucer.dto.ResponseDto;

public class ResultMapper {
    static ResponseDto mapToDto(ResultResponse resultResponse) {
        return ResponseDto.builder()
                .drawDate(resultResponse.drawDate)
                .hash(resultResponse.hash)
                .hitNumbers(resultResponse.hitNumbers)
                .numbers(resultResponse.numbers)
                .wonNumbers(resultResponse.wonNumbers)
                .isWinner(resultResponse.isWinner)
                .build();
    }
}