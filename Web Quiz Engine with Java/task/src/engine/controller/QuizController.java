package engine.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import engine.dto.QuizResponse;
import engine.dto.SolveResponse;
import engine.service.QuizService;

@RestController
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/api/quiz")
    public ResponseEntity<QuizResponse> getQuiz() {
        return ResponseEntity.ok(quizService.getQuiz());
    }

    @PostMapping("/api/quiz")
    public ResponseEntity<SolveResponse> solveQuiz(@RequestParam int answer) {
        return ResponseEntity.ok(quizService.solveQuiz(answer));
    }
}
