package pro.sky.coursework2.Service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.Exception.QuestionAmountExcess;
import pro.sky.coursework2.Interface.ExaminerService;
import pro.sky.coursework2.ClassQuestion.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (javaQuestionService.getAll().size() < amount) {
            throw new QuestionAmountExcess();
        }
        Set<Question> questions = new HashSet<>();
        for (int i = 1; questions.size() != amount; i++) {
            questions.add(javaQuestionService.getRandomQuestion());
        }
        return questions;
    }
}






