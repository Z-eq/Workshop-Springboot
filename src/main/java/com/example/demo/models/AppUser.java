package com.example.demo.models;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class AppUser {

    private int appuserId;

    private String username;

    private String password;

    private LocalDate regDate;

    private Details userDetails;



}
