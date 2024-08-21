package spring.lotto.domain.numbergenerator;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Document("winning_numbers")
public class WinningNumbers{

    @Id String id;
    @Field("draw_date") LocalDateTime date;
    @Field("winning_numbers") Set<Integer> winningNumbers;
}

