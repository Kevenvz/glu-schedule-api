package com.github.kevenvz.timetable.social.impl;

import com.github.kevenvz.timetable.social.CalendarOperations;
import com.github.kevenvz.timetable.social.Google;

public class GoogleTemplate extends org.springframework.social.google.api.impl.GoogleTemplate implements Google {
    private CalendarOperations calendarOperations;

    public GoogleTemplate() {
        initialize();
    }

    public GoogleTemplate(String accessToken) {
        super(accessToken);
        initialize();
    }

    private void initialize() {
        calendarOperations = new CalendarTemplate(getRestTemplate(), isAuthorized());
    }

    @Override
    public CalendarOperations calendarOperations() {
        return calendarOperations;
    }
}
