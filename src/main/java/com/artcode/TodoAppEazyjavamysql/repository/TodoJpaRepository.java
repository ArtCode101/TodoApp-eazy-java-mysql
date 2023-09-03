package com.artcode.TodoAppEazyjavamysql.repository;

import com.artcode.TodoAppEazyjavamysql.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Integer> {

}
