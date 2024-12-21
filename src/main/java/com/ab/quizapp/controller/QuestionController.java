package com.ab.quizapp.controller;

import com.ab.quizapp.model.Question;
import com.ab.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping()
    public ResponseEntity<List<Question>> getAllQuestions(){
      return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable Integer id){
        return questionService.getQuestionById(id);
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){

        return questionService.getQuestionByCatagory(category);
    }
    @PostMapping("")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        System.out.println(question);
    return questionService.addQuestion(question);
    }

    @PutMapping("")
    public ResponseEntity<Question> updateQuestion( @RequestBody Question question){
    return questionService.updateQuestionById(question);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id){
         return questionService.deleteQuestionById(id);
    }
}
