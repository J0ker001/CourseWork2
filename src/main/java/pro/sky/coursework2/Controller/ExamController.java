package pro.sky.coursework2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.ClassQuestion.Question;
import pro.sky.coursework2.Interface.ExaminerService;

import java.util.Collection;
;

@RestController
@RequestMapping("/exam")
public class ExamController {

    ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getRandom(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
