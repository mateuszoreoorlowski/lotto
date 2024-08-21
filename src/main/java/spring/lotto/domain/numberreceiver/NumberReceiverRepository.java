package spring.lotto.domain.numberreceiver;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface NumberReceiverRepository extends MongoRepository<Ticket, String> {
    Ticket save(Ticket entity);

    List<Ticket> findAllTicketsByDrawDate(LocalDateTime date);

    Optional<Ticket> findTicketByTicketId(String id);

}
