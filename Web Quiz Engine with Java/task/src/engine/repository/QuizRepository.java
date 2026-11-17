package engine.repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import engine.model.Quiz;

@Repository
public class QuizRepository {

    private final AtomicLong id = new AtomicLong(1);
    private final Map<Long, Quiz> quizzes = new ConcurrentHashMap<>();

    public Quiz save(Quiz quiz) {
        quiz.setId(id.getAndIncrement());
        quizzes.put(quiz.getId(), quiz);
        return quiz;
    }

    public Optional<Quiz> findById(Long id) {
        return Optional.ofNullable(quizzes.get(id));
    }

    public List<Quiz> findAll() {
        return quizzes.values().stream()
                .sorted(Comparator.comparing(Quiz::getId))
                .toList();
    }
}
