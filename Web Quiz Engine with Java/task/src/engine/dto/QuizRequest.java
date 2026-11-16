package engine.dto;

import java.util.List;

import engine.model.Quiz;

public record QuizRequest(String title, String text, List<String> options, int answer) {

    public static Quiz toQuiz(QuizRequest quizRequest) {
        List<String> options = quizRequest.options() == null ? List.of() : List.copyOf(quizRequest.options());
        return new Quiz(quizRequest.title(), quizRequest.text(), options, quizRequest.answer());
    }
}
