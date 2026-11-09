package engine.dto;

import java.util.List;

import engine.model.Quiz;

public record QuizResponse(String title, String text, List<String> options) {

    public static QuizResponse from(Quiz quiz) {
        return new QuizResponse(quiz.getTitle(), quiz.getText(), List.copyOf(quiz.getOptions()));
    }
}
