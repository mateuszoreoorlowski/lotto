package spring.lotto.domain.resultchecker;

public class PlayerResultNotFoundException extends RuntimeException{
    PlayerResultNotFoundException(String message) {
        super(message);
    }
}
