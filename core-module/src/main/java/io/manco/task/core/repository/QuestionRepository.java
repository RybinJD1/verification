package io.manco.task.core.repository;

import io.manco.task.core.domain.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

    Question findByDescription(String desc);
}
