package engine.dto;

import java.util.List;

import engine.model.Quiz;

public record QuizResponse(Long id, String title, String text, List<String> options) {

    public static QuizResponse from(Quiz quiz) {
        return new QuizResponse(quiz.getId(), quiz.getTitle(), quiz.getText(), List.copyOf(quiz.getOptions()));
    }
}
