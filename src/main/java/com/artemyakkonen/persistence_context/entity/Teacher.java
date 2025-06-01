package com.artemyakkonen.persistence_context.entity;

import jakarta.persistence.*;

@Cacheable(value = true)
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject")
    private Subject subject;

    @Column(name = "is_professor")
    private boolean isProfessor;

    public Teacher() {
    }

    public Teacher(String name, String surname, Subject subject, boolean isProfessor) {
        this.name = name;
        this.surname = surname;
        this.subject = subject;
        this.isProfessor = isProfessor;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public boolean isProfessor() {
        return isProfessor;
    }

    public void setProfessor(boolean professor) {
        isProfessor = professor;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", subject=" + subject +
                ", isProfessor=" + isProfessor +
                '}';
    }
}
