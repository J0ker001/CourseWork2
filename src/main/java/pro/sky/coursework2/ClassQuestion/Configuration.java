package pro.sky.coursework2.ClassQuestion;

import org.springframework.context.annotation.Bean;
import pro.sky.coursework2.Interface.QuestionInitializer;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public QuestionInitializer javaQuestionInitialize() {
        return new JavaQuestionInitialize();
    }
}
