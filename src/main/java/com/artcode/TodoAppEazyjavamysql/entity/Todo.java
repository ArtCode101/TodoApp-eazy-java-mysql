package com.artcode.TodoAppEazyjavamysql.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "todos")
public class Todo  {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private Integer id;

    @Column(name="topic")
    private String topic;

    @Column(name="message")
    private String message;

    @Column(name="status")
    private Boolean status = false;

    @Column(name="timestamp")
    private Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

}
