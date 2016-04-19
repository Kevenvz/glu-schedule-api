package com.github.kevenvz.timetable.social.impl;

import com.github.kevenvz.timetable.social.CalendarOperations;
import com.github.kevenvz.timetable.social.calendar.Calendar;
import com.github.kevenvz.timetable.social.calendar.CalendarList;
import org.springframework.social.google.api.impl.AbstractGoogleApiOperations;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

public class CalendarTemplate extends AbstractGoogleApiOperations implements CalendarOperations {

    private static final String CALENDAR_BASE_URL = "https://www.googleapis.com/calendar/v3";

    public CalendarTemplate(RestTemplate restTemplate, boolean isAuthorized) {
        super(restTemplate, isAuthorized);
        Assert.notNull(restTemplate, "RestTemplate must not be null");
    }

    @Override
    public CalendarList getAllCalendars() {
        return restTemplate.getForObject(CALENDAR_BASE_URL + "/users/me/calendarList", CalendarList.class);
    }

    @Override
    public Calendar getCalendar(String calendarId) {
        Assert.notNull(calendarId, "CalendarId must not be null");
        return restTemplate.getForObject(CALENDAR_BASE_URL + "/users/me/calendarList/" + calendarId, Calendar.class);
    }
}
