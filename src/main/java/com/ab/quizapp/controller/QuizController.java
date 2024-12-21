package com.ab.quizapp.controller;

import com.ab.quizapp.DAO.Quiz;
import com.ab.quizapp.model.Response;
import com.ab.quizapp.service.QuizeService;
import com.ab.quizapp.wrapper.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizeService quizeService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
//    return new ResponseEntity<>("I'm here", HttpStatus.OK);
        return quizeService.createQuiz(category,numQ,title);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id) {
    return quizeService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response> responses) {
    return quizeService.calculateResult(id,responses);
    }
}
