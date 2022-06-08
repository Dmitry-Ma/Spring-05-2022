package ru.otus.spring.service;

import ru.otus.spring.domain.Question;

import java.io.FileNotFoundException;

public interface QuestionService {

    void ask(Question question);

    Question[] getQuestions() throws FileNotFoundException;
}
