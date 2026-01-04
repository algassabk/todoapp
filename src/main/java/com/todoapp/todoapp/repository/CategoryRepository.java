package com.todoapp.todoapp.repository;


import com.todoapp.todoapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
