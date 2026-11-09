package engine.service;

import engine.dto.QuizResponse;
import engine.dto.SolveResponse;

public interface QuizService {

    QuizResponse getQuiz();
    SolveResponse solveQuiz(int answer);
}
