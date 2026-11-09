package engine.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import engine.dto.QuizResponse;
import engine.service.QuizService;

@Controller
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/api/quiz")
    public ResponseEntity<QuizResponse> getQuiz() {
        return ResponseEntity.ok(quizService.getQuiz());
    }
}
