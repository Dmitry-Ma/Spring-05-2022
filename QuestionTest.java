package ru.otus.spring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс Question")
class QuestionTest {

    @DisplayName("корректно создается конструктором и возвращает правильные значения")
    @Test
    void shouldHaveCorrectConstructor() {

        Answer answer = new Answer("Test", true);
        Question question = new Question("Test question", new Answer[]{answer});

        assertThat(question).matches(q -> q.getAnswers()[0] == answer && q.getQuestion().equals("Test question")) ;

    }

}