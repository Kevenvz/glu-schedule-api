package com.github.kevenvz.timetable.repository;

import com.github.kevenvz.timetable.model.Teacher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    Teacher findByCodename(String codename);

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE teacher AUTO_INCREMENT = 1", nativeQuery = true)
    void resetIncrement();
}
