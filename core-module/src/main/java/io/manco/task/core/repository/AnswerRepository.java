package io.manco.task.core.repository;

import io.manco.task.core.domain.Answer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {

    Answer findByDescription(String desc);

    List<Answer> findByQuestionId(Integer id);
}
