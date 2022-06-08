package ru.otus.spring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс Answer")
class AnswerTest {

    @DisplayName("корректно создается конструктором и возвращает правильные значения")
    @Test
    void shouldHaveCorrectConstructor() {

        Answer answer = new Answer("Test", true);
        assertThat(answer).matches(a -> a.isCorrect() == true && a.getAnswer().equals("Test")) ;

    }

}