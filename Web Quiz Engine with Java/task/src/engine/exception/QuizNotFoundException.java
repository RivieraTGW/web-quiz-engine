package engine.exception;

public class QuizNotFoundException extends RuntimeException {

    public QuizNotFoundException(Long id) {
        super("Quiz " + id + " not found");
    }
}
