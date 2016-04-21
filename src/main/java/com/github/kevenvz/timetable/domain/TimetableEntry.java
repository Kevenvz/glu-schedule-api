package com.github.kevenvz.timetable.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimetableEntry {
    @JsonProperty("class")
    private String studygroup;

    private String teacher;
    private String name;
    private String course;
    private String classroom;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Integer weekday;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Integer hour;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Integer weeknumber;

    public TimetableEntry() {
    }

    public String getStudygroup() {
        return studygroup;
    }

    public void setStudygroup(String studygroup) {
        this.studygroup = studygroup;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getWeeknumber() {
        return weeknumber;
    }

    public void setWeeknumber(Integer weeknumber) {
        this.weeknumber = weeknumber;
    }
}
