package com.github.kevenvz.timetable.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @Column(unique = true)
    private String codename;
    private String name;

    protected Teacher() {
    }

    public Teacher(String codename, String name) {
        this.codename = codename;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", codename='" + codename + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getCodename() {
        return codename;
    }

    public String getName() {
        return name;
    }
}
