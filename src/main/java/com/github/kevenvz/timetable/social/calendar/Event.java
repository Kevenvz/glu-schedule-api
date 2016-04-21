package com.github.kevenvz.timetable.social.calendar;

import org.springframework.social.google.api.ApiEntity;

public class Event extends ApiEntity {
    private String status;
    private String htmlLink;
    private String created;
    private String updated;
    private String summary;
    private String description;
    private String location;
    private Creator creator;
    private Organizer organizer;
    private Time start;
    private Time end;

    protected Event() {
        super();
    }

    public String getStatus() {
        return status;
    }

    public String getHtmlLink() {
        return htmlLink;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public Creator getCreator() {
        return creator;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public Time getStart() {
        return start;
    }

    public Time getEnd() {
        return end;
    }

    public static class Creator {
        private String email;
        private String displayName;

        public Creator() {
        }

        public String getEmail() {
            return email;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public static class Organizer {
        private String email;
        private String displayName;
        private Boolean self;

        public Organizer() {
        }

        public String getEmail() {
            return email;
        }

        public String getDisplayName() {
            return displayName;
        }

        public Boolean getSelf() {
            return self;
        }
    }

    public static class Time {
        private String dateTime;
        private String timeZone;

        public Time() {
        }

        public String getDateTime() {
            return dateTime;
        }

        public String getTimeZone() {
            return timeZone;
        }
    }
}
