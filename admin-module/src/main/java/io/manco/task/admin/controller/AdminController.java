package io.manco.task.admin.controller;

import io.manco.task.core.domain.Answer;
import io.manco.task.core.domain.Question;
import io.manco.task.core.service.AnswerService;

import io.manco.task.core.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = "/answer", method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> listAllAnswers() {
        List<Answer> answers = answerService.findAll();
        if (answers.isEmpty()) {
            return new ResponseEntity<List<Answer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Answer>>(answers, HttpStatus.OK);
    }

    @RequestMapping(value = "/answer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Answer> getAnswer(@PathVariable("id") int id) {
        System.out.println("Fetching Answer with id " + id);
        Answer answer = answerService.find(id);
        if (answer == null) {
            System.out.println("Answer with id " + id + " not found");
            return new ResponseEntity<Answer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Answer>(answer, HttpStatus.OK);
    }

    @RequestMapping(value = "/answer/", method = RequestMethod.POST)
    public ResponseEntity<Void> createAnswer(@RequestBody Answer answer, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Answer " + answer.getDescription());

        if (answerService.isAnswerExist(answer)) {
            System.out.println("A Answer with name " + answer.getDescription() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        answerService.save(answer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/answer/{id}").buildAndExpand(answer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/answer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Answer> updateAnswer(@PathVariable("id") int id, @RequestBody Answer answer) {
        System.out.println("Updating Answer " + id);
        Answer currentAnswer = answerService.find(id);
        if (currentAnswer == null) {
            System.out.println("Answer with id " + id + " not found");
            return new ResponseEntity<Answer>(HttpStatus.NOT_FOUND);
        }
        currentAnswer.setDescription(answer.getDescription());
        currentAnswer.setFlag(answer.isFlag());
        answerService.save(currentAnswer);
        return new ResponseEntity<Answer>(currentAnswer, HttpStatus.OK);
    }

    @RequestMapping(value = "/answer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Answer> deleteAnswer(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Answer with id " + id);

        Answer answer = answerService.find(id);
        if (answer == null) {
            System.out.println("Unable to delete. Answer with id " + id + " not found");
            return new ResponseEntity<Answer>(HttpStatus.NOT_FOUND);
        }

        answerService.delete(id);
        return new ResponseEntity<Answer>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public ResponseEntity<List<Question>> listAllQuestions() {
        List<Question> questions = questionService.findAll();
        if (questions.isEmpty()) {
            return new ResponseEntity<List<Question>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
    }

    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    public ResponseEntity<Question> getQuestion(@PathVariable("id") int id) {
        System.out.println("Fetching Question with id " + id);
        Question question = questionService.find(id);
        if (question == null) {
            System.out.println("Question with id " + id + " not found");
            return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Question>(question, HttpStatus.OK);
    }

    @RequestMapping(value = "/question/", method = RequestMethod.POST)
    public ResponseEntity<Void> createQuestion(@RequestBody Question question, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Question " + question.getDescription());

        if (questionService.isQuestionExist(question)) {
            System.out.println("A Question with name " + question.getDescription() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        questionService.save(question);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/question/{id}").buildAndExpand(question.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/question/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") int id, @RequestBody Question question) {
        System.out.println("Updating Question " + id);

        Question currentQuestion = questionService.find(id);

        if (currentQuestion == null) {
            System.out.println("Question with id " + id + " not found");
            return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
        }

        currentQuestion.setDescription(question.getDescription());

        questionService.save(currentQuestion);
        return new ResponseEntity<Question>(currentQuestion, HttpStatus.OK);
    }

    @RequestMapping(value = "/question/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Question> deleteQuestion(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Question with id " + id);

        Question question = questionService.find(id);
        if (question == null) {
            System.out.println("Unable to delete. Question with id " + id + " not found");
            return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
        }

        questionService.delete(id);
        return new ResponseEntity<Question>(HttpStatus.NO_CONTENT);
    }

}
