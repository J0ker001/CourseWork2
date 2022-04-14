package pro.sky.coursework2.Interface;

import pro.sky.coursework2.ClassQuestion.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
