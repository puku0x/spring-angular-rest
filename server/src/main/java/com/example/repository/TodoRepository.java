package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Todo;

/**
 * リポジトリ
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}