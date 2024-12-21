package com.ab.quizapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizeDAO extends JpaRepository<Quiz,Integer> {
}
