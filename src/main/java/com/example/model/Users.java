package com.example.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    private String userid;
    private String userpw;
    private String username;


}
