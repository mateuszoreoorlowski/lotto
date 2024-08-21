package spring.lotto.domain.numberreceiver;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Document("ticket")
public class Ticket {
    @Id String ticketId;
    @Field("draw_date") LocalDateTime drawDate;
    @Field("numbers_from_user") Set<Integer> numbersFromUser;
}
