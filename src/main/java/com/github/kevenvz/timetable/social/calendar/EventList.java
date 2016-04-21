package com.github.kevenvz.timetable.social.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.google.api.ApiEntity;

import java.util.List;

public class EventList extends ApiEntity {
    private String nextSyncToken;
    private String summary;
    @JsonProperty("items")
    private List<Event> events;

    protected EventList() {
        super();
    }

    public String getNextSyncToken() {
        return nextSyncToken;
    }

    public String getSummary() {
        return summary;
    }

    public List<Event> getEvents() {
        return events;
    }
}
