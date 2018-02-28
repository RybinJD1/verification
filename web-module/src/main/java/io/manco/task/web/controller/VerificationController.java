package io.manco.task.web.controller;

import io.manco.task.core.domain.Answer;
import io.manco.task.core.domain.Question;
import io.manco.task.core.service.AnswerService;
import io.manco.task.core.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/verification")
public class VerificationController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = "/randomQuestion", method = RequestMethod.GET)
    public ResponseEntity<Question> getRandomQuestion() {
        Question question = questionService.getRandomQuestion();
        if (question == null) {
            return new ResponseEntity<Question>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Question>(question, HttpStatus.OK);
    }

    @RequestMapping(value = "/right/{ans}", method = RequestMethod.GET)
    public ResponseEntity<Answer> getRightAnswer(@PathVariable("ans") String ans) {
        Answer answer = answerService.findByDescription(ans);
        if (!answer.isFlag()) {
            return new ResponseEntity<Answer>(answer, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Answer>(answer, HttpStatus.OK);
        }
    }

}
