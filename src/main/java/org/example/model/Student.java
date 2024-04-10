package org.example.model;

import jakarta.persistence.*;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_Name", nullable = false, length = 150)
    private String firstName;

    @Column(name = "last_Name", nullable = false, length = 250)
    private String lastName;


    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
