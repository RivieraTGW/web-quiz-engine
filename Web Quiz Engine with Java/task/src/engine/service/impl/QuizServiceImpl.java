package engine.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import engine.dto.QuizRequest;
import engine.dto.QuizResponse;
import engine.dto.SolveRequest;
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
    public QuizResponse createQuiz(QuizRequest quizRequest) {
        Quiz quiz = QuizRequest.toQuiz(quizRequest);
        return QuizResponse.from(quizRepository.save(quiz));
    }

    @Override
    public QuizResponse getQuiz(Long id) {
        return QuizResponse.from(findQuiz(id));
    }

    @Override
    public List<QuizResponse> getAllQuizzes() {
        return quizRepository.findAll().stream()
                .map(QuizResponse::from)
                .toList();
    }

    @Override
    public SolveResponse solveQuiz(Long id, SolveRequest solveRequest) {
        Set<Integer> quizAnswerAsSet = Set.copyOf(findQuiz(id).getAnswer());
        Set<Integer> requestAnswerAsSet = Set.copyOf(solveRequest.answer());
        return quizAnswerAsSet.equals(requestAnswerAsSet) ? SolveResponse.correct() : SolveResponse.wrong();
    }

    private Quiz findQuiz(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException(id));
    }
}
