package ru.otus.spring.domain;

public class Answer {

    private final String answer;
    private final boolean isCorrect;

    public Answer(String ans, boolean isCorrect) {
        this.answer = ans;
        this.isCorrect = isCorrect;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
