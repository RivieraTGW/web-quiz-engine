package engine.service.impl;

import org.springframework.stereotype.Service;

import engine.dto.QuizResponse;
import engine.dto.SolveResponse;
import engine.exception.QuizNotFoundException;
import engine.model.Quiz;
import engine.repository.QuizRepository;
import engine.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public QuizResponse getQuizById(Long id) {
        return QuizResponse.from(quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException(id)));
    }

    @Override
    public SolveResponse solveQuiz(Long id, int answer) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException(id));
        boolean success = answer == quiz.getAnswer();
        return success ? SolveResponse.correct() : SolveResponse.wrong();
    }
}
