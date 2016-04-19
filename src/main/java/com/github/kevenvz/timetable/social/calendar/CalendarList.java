package com.github.kevenvz.timetable.social.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.google.api.ApiEntity;

import java.util.List;

public class CalendarList extends ApiEntity {
    private String nextSyncToken;
    @JsonProperty("items")
    private List<Calendar> calendars;

    protected CalendarList() {
        super();
    }

    public String getNextSyncToken() {
        return nextSyncToken;
    }

    public List<Calendar> getCalendars() {
        return calendars;
    }
}
