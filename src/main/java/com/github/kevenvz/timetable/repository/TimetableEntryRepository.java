package com.github.kevenvz.timetable.repository;

import com.github.kevenvz.timetable.model.TimetableEntry;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TimetableEntryRepository extends CrudRepository<TimetableEntry, Long> {

    List<TimetableEntry> findAll();

    List<TimetableEntry> findByStudygroup(String studygroup);

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE timetable_entry AUTO_INCREMENT = 1", nativeQuery = true)
    void resetIncrement();
}
