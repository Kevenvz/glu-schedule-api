package com.github.kevenvz.timetable.service;

import com.github.kevenvz.timetable.domain.Teacher;
import com.github.kevenvz.timetable.domain.TimetableEntry;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.List;

@Service
public class ScrapeService {
    private String scrapeUrl;
    private RestTemplate restTemplate;

    @Inject
    public ScrapeService(Environment environment) {
        this.scrapeUrl = environment.getProperty("timetable.scrape-url");
        this.restTemplate = new RestTemplate();
    }

    public List<Teacher> scrapeTeachers() {
        final ResponseEntity<List<Teacher>> response = restTemplate.exchange(scrapeUrl + "/dumpteacher", HttpMethod.GET, null, new ParameterizedTypeReference<List<Teacher>>() {
        });
        return response.getBody();
    }

    public List<TimetableEntry> scrapeTimetable() {
        final ResponseEntity<List<TimetableEntry>> response = restTemplate.exchange(scrapeUrl + "/dump", HttpMethod.GET, null, new ParameterizedTypeReference<List<TimetableEntry>>() {
        });
        return response.getBody();
    }
}
