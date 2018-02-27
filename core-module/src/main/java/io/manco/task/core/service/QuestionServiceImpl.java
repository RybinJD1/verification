package io.manco.task.core.service;

import com.google.common.collect.Lists;
import io.manco.task.core.domain.Answer;
import io.manco.task.core.domain.Question;
import io.manco.task.core.repository.AnswerRepository;
import io.manco.task.core.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question find(Integer id) {
        return questionRepository.findOne(id);
    }

    @Override
    public List<Question> findAll() {
        return  Lists.newArrayList(questionRepository.findAll());
    }

    @Override
    public void delete(Integer id) {
        questionRepository.delete(id);
    }

    @Override
    public Question findByDescription(String desc) {
        return questionRepository.findByDescription(desc);
    }

    @Override
    public boolean isQuestionExist(Question question) {
        return findByDescription(question.getDescription())!=null;
    }

    @Override
    public Question getRandomQuestion(){
        while (true){
            List<Question> questions = Lists.newArrayList(questionRepository.findAll());
            Collections.shuffle(questions);
            Question question = questions.get(0);

            List<Answer> listAnswers = answerRepository.findByQuestionId(question.getId());
            if(!listAnswers.isEmpty()) {
                question.setListAnswers(listAnswers);
                return question;
            }
        }
    }

}
