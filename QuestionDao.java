package ru.otus.spring.dao;

import ru.otus.spring.domain.Question;

import java.io.FileNotFoundException;

public interface QuestionDao {

    void setFileName(String fileName);

    Question[] read() throws FileNotFoundException;

}
