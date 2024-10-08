package spring.lotto.domain.numberreceiver;

import spring.lotto.domain.numberreceiver.dto.TicketDto;
public class TicketMapper {

    public static TicketDto mapFromTicket(Ticket ticket) {
        return TicketDto.builder()
                .numbersFromUser(ticket.numbersFromUser)
                .ticketId(ticket.ticketId)
                .drawDate(ticket.drawDate)
                .build();
    }
}
