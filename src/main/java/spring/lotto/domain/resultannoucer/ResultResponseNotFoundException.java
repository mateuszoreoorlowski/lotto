package spring.lotto.domain.resultannoucer;

public class ResultResponseNotFoundException extends RuntimeException{
    ResultResponseNotFoundException(String message) {
        super(message);
    }
}
