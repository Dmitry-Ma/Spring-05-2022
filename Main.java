package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.domain.Question;
import ru.otus.spring.service.QuestionService;

import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // TODO: создайте здесь класс контекста
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        // TODO: Получите Person Service
        QuestionService service = context.getBean(QuestionService.class);

        Question[] q = service.getQuestions();
        for (Question question : q) {
            service.ask(question);
        }
    }
}
