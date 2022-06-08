package ru.otus.spring.service;

import ru.otus.spring.dao.QuestionDao;
import ru.otus.spring.domain.Question;

import java.io.FileNotFoundException;

public class QuestionServiceImpl implements  QuestionService{

    private final QuestionDao dao;

    QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public void ask(Question question) {
        String q = question.getQuestion();

        System.out.println(q.lastIndexOf("?") == q.length() ? q: q + "?" );
        for (int i = 0 ; i<question.getAnswers().length ; i++) {
            System.out.println(1+i+". " + question.getAnswers()[i].getAnswer());
        }
    }

    @Override
    public Question[] getQuestions() throws FileNotFoundException {
        return dao.read();
    }

}
