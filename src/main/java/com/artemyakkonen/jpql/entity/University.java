package com.artemyakkonen.jpql.entity;


import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "universities")
//@NamedQuery(name = "University.allUniversitiesLessOrEqualTo2",
//        query = "select u from University u where size(u.students) <= 2")
//@NamedQuery(name = "University.studentsWithAvgGradeBetween",
//        query = "select s from Student s where s.avgGrade between :from and :to")
@NamedQueries(
        {
                @NamedQuery(name = "University.allUniversitiesLessOrEqualTo2",
                        query = "select u from University u where size(u.students) <= 2"),

                @NamedQuery(name = "University.studentsWithAvgGradeBetween",
                        query = "select s from Student s where s.avgGrade between :from and :to")
        }
)

public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "founding_date")
    private Date foundingDate;

    @OneToMany(mappedBy = "university")
    private List<Student> students = new ArrayList<>();

    public University() {
    }

    public University(String name, Date foundingDate) {
        this.name = name;
        this.foundingDate = foundingDate;
    }

    public void addStudentToUniversity(Student student){
        students.add(student);
        student.setUniversity(this);
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

    public Date getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(Date foundingDate) {
        this.foundingDate = foundingDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setList(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foundingDate=" + foundingDate +
                '}';
    }
}
