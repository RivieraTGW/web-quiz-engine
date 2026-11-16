package engine.repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import engine.model.Quiz;

@Repository
public class QuizRepository {

    private Map<Long, Quiz> quizzes = new ConcurrentHashMap<>();

    public Optional<Quiz> findById(Long id) {
        return Optional.ofNullable(quizzes.get(id));
    }
}
