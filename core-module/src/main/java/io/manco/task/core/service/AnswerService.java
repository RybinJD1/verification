package io.manco.task.core.service;

import io.manco.task.core.domain.Answer;

import java.util.List;

public interface AnswerService {

    Answer save(Answer answer);

    Answer find(Integer id);

    List<Answer> findAll();

    List<Answer> findByQuestionId(Integer id);

    void delete(Integer id);

    Answer findByDescription(String desc);

    boolean isAnswerExist(Answer answer);


}
