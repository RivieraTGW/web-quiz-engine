package engine.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import engine.dto.QuizResponse;
import engine.dto.SolveResponse;
import engine.service.QuizService;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizResponse> getQuizById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getQuizById(id));
    }

    @PostMapping("/{id}/solve")
    public ResponseEntity<SolveResponse> solveQuiz(@PathVariable Long id, @RequestParam int answer) {
        return ResponseEntity.ok(quizService.solveQuiz(id, answer));
    }
}
