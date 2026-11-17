package engine.service;

import java.util.List;

import engine.dto.QuizRequest;
import engine.dto.QuizResponse;
import engine.dto.SolveResponse;

public interface QuizService {

    QuizResponse createQuiz(QuizRequest quizRequest);
    QuizResponse getQuiz(Long id);
    List<QuizResponse> getAllQuizzes();
    SolveResponse solveQuiz(Long id, int answer);
}
