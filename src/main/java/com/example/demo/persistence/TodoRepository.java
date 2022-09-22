package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    // ?1은 method의 매개변수 순서 위치 의미함
    @Query("SELECT * FROM Todo t WHERE t.userId = ?1")
    List<TodoEntity> findByUserId(String userId);
}

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByUserId(String userId);
}