package com.github.kevenvz.timetable.controller;

import com.github.kevenvz.timetable.model.TimetableEntry;
import com.github.kevenvz.timetable.repository.TimetableEntryRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/timetable")
public class TimetableController {
    private final TimetableEntryRepository timetableEntryRepository;

    @Inject
    public TimetableController(TimetableEntryRepository timetableEntryRepository) {
        this.timetableEntryRepository = timetableEntryRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<TimetableEntry> findAllEntries() {
        return timetableEntryRepository.findAll();
    }

    @RequestMapping(path = "/{studygroup}")
    public List<TimetableEntry> findByStudygroup(@PathVariable("studygroup") String studygroup) {
        return timetableEntryRepository.findByStudygroup(studygroup);
    }
}
