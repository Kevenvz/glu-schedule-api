package com.github.kevenvz.timetable.controller;

import com.github.kevenvz.timetable.model.Teacher;
import com.github.kevenvz.timetable.repository.TeacherRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherRepository teacherRepository;

    @Inject
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }
}
