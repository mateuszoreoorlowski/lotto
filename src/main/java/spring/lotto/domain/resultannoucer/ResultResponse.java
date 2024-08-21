package spring.lotto.domain.resultannoucer;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Document("result")
public class ResultResponse {

        @Id String hash;
        @Field("numbers") Set<Integer> numbers;
        @Field("won_numbers") Set<Integer> wonNumbers;
        @Field("hit_numbers") Set<Integer> hitNumbers;
        @Field("draw_date") LocalDateTime drawDate;
        @Field("is_winner") boolean isWinner;
        @Field("created_date") LocalDateTime createdDate;
}