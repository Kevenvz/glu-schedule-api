package com.github.kevenvz.timetable.social;

import com.github.kevenvz.timetable.social.calendar.Calendar;
import com.github.kevenvz.timetable.social.calendar.CalendarList;
import com.github.kevenvz.timetable.social.calendar.EventList;

public interface CalendarOperations {
    String PRIMARY_CALENDAR_ID = "primary";

    CalendarList getAllCalendars();

    Calendar getCalendar(String calendarId);

    EventList getEventList(String calendarId);
}
