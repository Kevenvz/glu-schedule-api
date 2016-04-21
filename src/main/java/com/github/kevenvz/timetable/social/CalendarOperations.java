package com.github.kevenvz.timetable.social;

import com.github.kevenvz.timetable.social.calendar.Calendar;
import com.github.kevenvz.timetable.social.calendar.CalendarList;

public interface CalendarOperations {
    String PRIMARY_CALENDAR_ID = "primary";

    CalendarList getAllCalendars();

    Calendar getCalendar(String calendarId);
}
