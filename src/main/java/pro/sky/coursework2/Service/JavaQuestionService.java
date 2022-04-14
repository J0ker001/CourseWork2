package pro.sky.coursework2.Service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.Exception.AlreadyExists;
import pro.sky.coursework2.Exception.NoContent;
import pro.sky.coursework2.Exception.NotFound;
import pro.sky.coursework2.Interface.QuestionInitializer;
import pro.sky.coursework2.Interface.QuestionService;
import pro.sky.coursework2.ClassQuestion.Question;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService {

    private Random random = new Random(1);
    private Set<Question> questionSet = new HashSet<>();

    private int random(int count) {
        return random.nextInt(count);
    }


    public JavaQuestionService(@Qualifier("javaQuestionInitialize") QuestionInitializer questionInitializer) {
        this.questionSet = questionInitializer.getQuestions();
    }

    @Override
    public Question add(String question, String answer) {
        Question questionX = new Question(question, answer);
        if (questionSet.add(new Question(question, answer)) == false) {
            throw new AlreadyExists("Уже существует");
        }
        return questionX;
    }

    @Override
    public Question add(Question question) {
        if (questionSet.add(question) == false) {
            throw new AlreadyExists("Уже существует");
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questionSet.contains(question) != true) {
            throw new NotFound("Такого нет");
        }
        questionSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        if (questionSet.isEmpty()) {
            throw new NoContent();
        }
        return Collections.unmodifiableCollection(questionSet);
    }

    @Override
    public Question getRandomQuestion() {
        if (questionSet.isEmpty()) {
            throw new NoContent();
        }
        Question question = null;
        int x = random(questionSet.size());
        var itr = questionSet.iterator();
        for (int i = 0; i < x + 1; i++) {
            question = itr.next();
        }
        return question;
    }
}
