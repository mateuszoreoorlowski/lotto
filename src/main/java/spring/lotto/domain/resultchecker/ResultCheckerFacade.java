package spring.lotto.domain.resultchecker;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import spring.lotto.domain.numbergenerator.NumberGeneratorFacade;
import spring.lotto.domain.numbergenerator.dto.WinningNumbersDto;
import spring.lotto.domain.numberreceiver.NumberReceiverFacade;
import spring.lotto.domain.numberreceiver.dto.TicketDto;
import spring.lotto.domain.resultchecker.dto.PlayersDto;
import spring.lotto.domain.resultchecker.dto.ResultDto;
import spring.lotto.domain.resultchecker.dto.ResultState;

import java.util.List;
import java.util.Set;


@Component
@AllArgsConstructor
public class ResultCheckerFacade {

    NumberGeneratorFacade numberGeneratorFacade;
    NumberReceiverFacade numberReceiverFacade;
    PlayerRepository playerRepository;
    WinnersRetriever winnerGenerator;

    public PlayersDto generateResults() {
        List<TicketDto> allTicketsByDate = numberReceiverFacade.retrieveAllTicketsByNextDrawDate();
        List<Ticket> tickets = ResultCheckerMapper.mapFromTicketDto(allTicketsByDate);
        WinningNumbersDto winningNumbersDto = numberGeneratorFacade.generateWinningNumbers();
        Set<Integer> winningNumbers = winningNumbersDto.getWinningNumbers();
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            return PlayersDto.builder()
                    .message("Winners failed to retrieve")
                    .build();
        }
        List<Player> players = winnerGenerator.retrieveWinners(tickets, winningNumbers);
        playerRepository.saveAll(players);
        return PlayersDto.builder()
                .results(ResultCheckerMapper.mapPlayersToResults(players))
                .message("Winners succeeded to retrieve")
                .build();
    }

    public ResultDto findByTicketId(String ticketId) {
        if(numberReceiverFacade.ticketExistsByIdAndTimeIsBeforeDrawDate(ticketId)){
            return ResultDto.builder()
                    .hash(ticketId)
                    .resultState(ResultState.WAIT)
                    .build();
        }
        Player player = playerRepository.findById(ticketId)
                .orElseThrow(() -> new PlayerResultNotFoundException("Not found for id: " + ticketId));
        return ResultDto.builder()
                .hash(ticketId)
                .numbers(player.numbers)
                .hitNumbers(player.hitNumbers)
                .drawDate(player.drawDate)
                .wonNumbers(player.wonNumbers)
                .isWinner(player.isWinner)
                .resultState(ResultState.SUCCESS)
                .build();
    }
}