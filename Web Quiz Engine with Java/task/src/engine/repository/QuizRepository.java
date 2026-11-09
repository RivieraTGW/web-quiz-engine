package engine.repository;

import java.util.Arrays;

import org.springframework.stereotype.Repository;

import engine.model.Quiz;

@Repository
public class QuizRepository {

    private final Quiz quiz = new Quiz();;

    public QuizRepository() {
        initDummyQuiz();
    }

    private void initDummyQuiz() {
        quiz.setTitle("The Java Logo");
        quiz.setText("What is depicted on the Java logo?");
        quiz.setOptions(Arrays.asList("Robot", "Tea leaf", "Cup of coffee", "Bug"));
        quiz.setAnswer(2);
    }

    public Quiz getQuiz() {
        return quiz;
    }
}
