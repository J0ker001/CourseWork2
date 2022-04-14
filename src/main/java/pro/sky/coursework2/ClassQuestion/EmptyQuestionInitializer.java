package pro.sky.coursework2.ClassQuestion;

import pro.sky.coursework2.Interface.QuestionInitializer;

import java.util.HashSet;
import java.util.Set;

public class EmptyQuestionInitializer implements QuestionInitializer {
    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>();
    }
}
