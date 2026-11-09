package engine.service.impl;

import org.springframework.stereotype.Service;

import engine.dto.QuizResponse;
import engine.dto.SolveResponse;
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
    public QuizResponse getQuiz() {
        Quiz quiz = quizRepository.getQuiz();
        return QuizResponse.from(quiz);
    }

    @Override
    public SolveResponse solveQuiz(int answer) {
        boolean success = answer == quizRepository.getQuiz().getAnswer();
        return success ? SolveResponse.correct() : SolveResponse.wrong();
    }
}
