package com.springk.apidemos.Dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "\"User\"")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String password;


    @Override
    public String toString() {
        return "User [userid=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
    }


    
}
