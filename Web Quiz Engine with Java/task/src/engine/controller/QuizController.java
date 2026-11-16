package engine.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<QuizResponse> getQuiz(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getQuiz(id));
    }

    @PostMapping("/{id}/solve")
    public ResponseEntity<SolveResponse> solveQuiz(@PathVariable Long id, @RequestParam int answer) {
        return ResponseEntity.ok(quizService.solveQuiz(id, answer));
    }
}
