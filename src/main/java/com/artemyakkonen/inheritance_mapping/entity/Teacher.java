package com.artemyakkonen.inheritance_mapping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Teacher extends Employee{
    @Column(name = "subject")
    private String subject;

    @Column(name = "is_professor")
    private Boolean isProfessor;

    public Teacher() {
    }

    public Teacher(String name, Integer salary, Double experience, String subject, Boolean isProfessor) {
        super(name, salary, experience);
        this.subject = subject;
        this.isProfessor = isProfessor;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + getId() + '\'' +
                "name='" + getName() + '\'' +
                "salary='" + getSalary() + '\'' +
                "experience='" + getExperience() + '\'' +
                "subject='" + subject + '\'' +
                ", is_professor=" + isProfessor +
                '}';
    }
}
