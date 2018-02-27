package io.manco.task.core.service;

import io.manco.task.core.domain.Question;

import java.util.List;

public interface QuestionService {

    Question save(Question question);

    Question find(Integer id);

    List<Question> findAll();

    void delete(Integer id);

    Question findByDescription(String desc);

    boolean isQuestionExist(Question question);

    Question getRandomQuestion();
}
