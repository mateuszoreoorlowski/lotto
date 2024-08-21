package spring.lotto.domain.resultannoucer;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ResponseRepository extends MongoRepository<ResultResponse, String> {

    ResultResponse save (ResultResponse resultResponse);

    Optional<ResultResponse> findById (String hash);

    boolean existsById(String hash);
}
