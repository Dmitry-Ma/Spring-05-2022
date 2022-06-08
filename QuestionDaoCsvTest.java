package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.domain.Question;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс QuestionDaoCsv")
class QuestionDaoCsvTest {

    QuestionDao daoCsv = new QuestionDaoCsv();

    @DisplayName("при чтении дефолтного файла будет создано 5 вопросов, в 4 вопросе 4 ответа")
    @Test
    void read() {
        Question[] q = new Question[0];
        try {
            q = daoCsv.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertThat(q[3].getAnswers()[3].getAnswer()).isEqualTo(" Different");
    }

    @DisplayName("при попытке передать несущестующий файл будет выдана ошибка")
    @Test
    void setFileName() {
        daoCsv.setFileName("notExistingFile.csv");
        assertThatThrownBy(() -> { daoCsv.read(); }).hasMessage("file notExistingFile.csv not found in resources!");
    }

}