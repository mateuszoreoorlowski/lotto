package spring.lotto.domain.resultchecker;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Document("player")
public class Player {

    @Id String hash;
    @Field("numbers") Set<Integer> numbers;
    @Field("hit_numbers") Set<Integer> hitNumbers;
    @Field("draw_date") LocalDateTime drawDate;
    @Field("is_winner") boolean isWinner;
    @Field("won_numbers") Set<Integer> wonNumbers;
}

