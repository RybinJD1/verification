package io.manco.task.core.service.impl;

import com.google.common.collect.Lists;
import io.manco.task.core.domain.Answer;
import io.manco.task.core.repository.AnswerRepository;
import io.manco.task.core.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository repository;

    public AnswerServiceImpl(AnswerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Answer save(Answer answer) {
        return repository.save(answer);
    }

    @Override
    public Answer find(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public List<Answer> findAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public List<Answer> findByQuestionId(Integer id) {
        return repository.findByQuestionId(id);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public Answer findByDescription(String desc) {
        return repository.findByDescription(desc);
    }


    public boolean isAnswerExist(Answer answer) {
        return findByDescription(answer.getDescription()) != null;
    }
}
