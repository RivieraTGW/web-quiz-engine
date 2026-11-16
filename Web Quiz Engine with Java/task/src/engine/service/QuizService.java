package engine.service;

import engine.dto.QuizResponse;
import engine.dto.SolveResponse;

public interface QuizService {

    QuizResponse getQuiz(Long id);
    SolveResponse solveQuiz(Long id, int answer);
}
