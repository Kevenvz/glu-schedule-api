package com.github.kevenvz.timetable.social.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.TimeZone;

public class TimeZoneDeserializer extends JsonDeserializer<TimeZone> {
    @Override
    public TimeZone deserialize(JsonParser jp, DeserializationContext ctxt)
            throws JsonParseException, IOException {
        return TimeZone.getTimeZone(jp.getValueAsString());
    }
}
