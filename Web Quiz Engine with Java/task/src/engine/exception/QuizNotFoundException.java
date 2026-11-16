package engine.exception;

public class QuizNotFoundException extends RuntimeException {

    private Long id;

    public QuizNotFoundException(Long id) {
        super("");

        this.id = id;
    }
}
