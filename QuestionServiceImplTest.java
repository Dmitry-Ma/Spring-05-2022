package ru.otus.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.dao.QuestionDaoCsv;

import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceImplTest {

    QuestionDaoCsv dao = new QuestionDaoCsv();
    QuestionService service =  new QuestionServiceImpl(dao);



    @DisplayName("проверить, что правильно возвращаются значения")
    @Test
    void getQuestions() {
        try {
            assertThat(service.getQuestions()[3].getAnswers()[3].getAnswer()).isEqualTo(" Different");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}