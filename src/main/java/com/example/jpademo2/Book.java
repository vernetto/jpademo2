package com.example.jpademo2;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    Long id;
    String title;
}
