package engine.dto;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import engine.model.Quiz;

public record QuizRequest(
        @NotBlank String title,
        @NotBlank String text,
        @NotNull @Size(min=2) List<@NotNull String> options,
        List<@NotNull Integer> answer) {

    public static Quiz toQuiz(QuizRequest quizRequest) {
        List<String> options = List.copyOf(quizRequest.options());
        List<Integer> answer = quizRequest.answer() == null ? List.of() : List.copyOf(quizRequest.answer());
        return new Quiz(quizRequest.title(), quizRequest.text(), options, answer);
    }
}
