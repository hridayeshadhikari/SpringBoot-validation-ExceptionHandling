package com.handleexception.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studId;
    @NotNull(message="first name cannot be null")
    @NotEmpty(message="first name cannot be empty")
    private String firstName;
    @NotNull(message="first name cannot be null")
    @NotEmpty(message="first name cannot be empty")
    private String lastName;

    private Long age;
    private String phoneNumber;
    private String email;
}
