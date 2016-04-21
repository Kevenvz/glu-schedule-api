package com.github.kevenvz.timetable.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class TimetableEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    private String studygroup;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    private String lesson;
    private String room;
    private Integer weeknumber;
    private Integer weekday;
    private Integer hour;

    protected TimetableEntry() {
    }

    public TimetableEntry(String studygroup, Teacher teacher, String lesson, String room, Integer weeknumber, Integer weekday, Integer hour) {
        this.studygroup = studygroup;
        this.teacher = teacher;
        this.lesson = lesson;
        this.room = room;
        this.weeknumber = weeknumber;
        this.weekday = weekday;
        this.hour = hour;
    }

    public TimetableEntry(com.github.kevenvz.timetable.domain.TimetableEntry timetableEntry, Teacher teacher) {
        this.studygroup = timetableEntry.getStudygroup();
        this.teacher = teacher;
        this.lesson = timetableEntry.getCourse();
        this.room = timetableEntry.getClassroom();
        this.weeknumber = timetableEntry.getWeeknumber();
        this.weekday = timetableEntry.getWeekday();
        this.hour = timetableEntry.getHour();
    }

    @Override
    public String toString() {
        return "TimetableEntry{" +
                "id=" + id +
                ", studygroup='" + studygroup + '\'' +
                ", teacher=" + teacher +
                ", lesson='" + lesson + '\'' +
                ", room='" + room + '\'' +
                ", weeknumber=" + weeknumber +
                ", weekday=" + weekday +
                ", hour=" + hour +
                '}';
    }

    public String getStudygroup() {
        return studygroup;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getLesson() {
        return lesson;
    }

    public String getRoom() {
        return room;
    }

    public Integer getWeeknumber() {
        return weeknumber;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public Integer getHour() {
        return hour;
    }
}
