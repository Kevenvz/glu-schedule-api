package com.github.kevenvz.timetable.social;

public interface Google extends org.springframework.social.google.api.Google {
    CalendarOperations calendarOperations();
}
