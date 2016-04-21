package com.github.kevenvz.timetable.service;

import com.github.kevenvz.timetable.model.Teacher;
import com.github.kevenvz.timetable.model.TimetableEntry;
import com.github.kevenvz.timetable.repository.TeacherRepository;
import com.github.kevenvz.timetable.repository.TimetableEntryRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

@Service
public class MigrationService {
    @Inject
    private ScrapeService scrapeService;

    @Inject
    private TeacherRepository teacherRepository;

    @Inject
    private TimetableEntryRepository timetableEntryRepository;

    @Transactional
    @Async
    public Future<Map<String, Teacher>> migrateTeachers() throws InterruptedException {
        final List<com.github.kevenvz.timetable.domain.Teacher> teachers = scrapeService.scrapeTeachers();
        final Map<String, Teacher> teacherMap = new HashMap<String, Teacher>();

        teacherRepository.deleteAll();
        teacherRepository.resetIncrement();
        teachers.stream()
                .forEach((teacher ->
                        teacherMap.put(
                                teacher.getCodename(),
                                teacherRepository.save(new Teacher(teacher.getCodename(), teacher.getName()))
                        )
                ));

        return new AsyncResult<Map<String, Teacher>>(teacherMap);
    }

    @Transactional
    @Async
    public Future<List<TimetableEntry>> migrateTimetableEntries(Map<String, Teacher> teacherMap) throws InterruptedException {
        final List<com.github.kevenvz.timetable.domain.TimetableEntry> timetableEntries = scrapeService.scrapeTimetable();
        final List<TimetableEntry> timetableEntryList = new ArrayList<TimetableEntry>();

        timetableEntryRepository.deleteAll();
        timetableEntryRepository.resetIncrement();
        timetableEntries.stream()
                .forEach((timetableEntry ->
                        timetableEntryList.add(timetableEntryRepository.save(new TimetableEntry(
                                timetableEntry.getStudygroup(),
                                teacherMap.get(timetableEntry.getTeacher()),
                                timetableEntry.getCourse(),
                                timetableEntry.getClassroom(),
                                timetableEntry.getWeeknumber(),
                                timetableEntry.getWeekday(),
                                timetableEntry.getHour()
                        )))
                ));

        return new AsyncResult<List<TimetableEntry>>(timetableEntryList);
    }
}
