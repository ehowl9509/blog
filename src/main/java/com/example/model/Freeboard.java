package com.example.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "freeboard")
public class Freeboard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long freeId;
    private String content;
    private String title;
    private String writer;

}
