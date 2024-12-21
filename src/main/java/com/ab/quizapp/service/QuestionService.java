package com.ab.quizapp.service;

import com.ab.quizapp.DAO.QuestionDAO;
import com.ab.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionDAO questionDAO;;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<Optional<Question>> getQuestionById(Integer id) {
        try {
            return new ResponseEntity<>(questionDAO.findById(id), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(Optional.empty(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCatagory(String category) {
        try {
            return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> addQuestion(Question question) {
        try {
            return new ResponseEntity<>(questionDAO.save(question), HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
       return new ResponseEntity<>(new Question(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> updateQuestionById(Question question) {
        return new ResponseEntity<>(questionDAO.save(question), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteQuestionById(Integer id) {
        questionDAO.deleteById(id);
        return new ResponseEntity<>("Successfully deleted row with id "+id,HttpStatus.OK);
    }
}
