package com.github.kevenvz.timetable.social.calendar;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.kevenvz.timetable.social.impl.TimeZoneDeserializer;
import com.github.kevenvz.timetable.social.impl.TimeZoneSerializer;
import org.springframework.social.google.api.ApiEntity;

import java.util.TimeZone;

public class Calendar extends ApiEntity {
    private String summary;
    private String description;

    @JsonDeserialize(using = TimeZoneDeserializer.class)
    @JsonSerialize(using = TimeZoneSerializer.class)
    private TimeZone timeZone;

    private String colorId;
    private String backgroundColor;
    private String foregroundColor;

    protected Calendar() {
        super();
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public String getColorId() {
        return colorId;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getForegroundColor() {
        return foregroundColor;
    }
}
