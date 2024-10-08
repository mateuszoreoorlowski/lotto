package spring.lotto.domain.resultchecker;

import spring.lotto.domain.resultchecker.dto.ResultDto;
import spring.lotto.domain.numberreceiver.dto.TicketDto;
import java.util.List;
import java.util.stream.Collectors;

class ResultCheckerMapper {

    static List<ResultDto> mapPlayersToResults(List<Player> players) {
        return players.stream()
                .map(player -> ResultDto.builder()
                        .hash(player.hash)
                        .numbers(player.numbers)
                        .hitNumbers(player.hitNumbers)
                        .drawDate(player.drawDate)
                        .isWinner(player.isWinner)
                        .wonNumbers(player.wonNumbers)
                        .build())
                .collect(Collectors.toList());
    }

    static List<Ticket> mapFromTicketDto(List<TicketDto> allTicketsByDate) {
        return allTicketsByDate.stream()
                .map(ticketDto -> Ticket.builder()
                        .drawDate(ticketDto.drawDate())
                        .hash(ticketDto.ticketId())
                        .numbers(ticketDto.numbersFromUser())
                        .build())
                .toList();
    }
}