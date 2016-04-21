package com.github.kevenvz.timetable.controller;

import com.github.kevenvz.timetable.social.Google;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
@RequestMapping("/")
public class WebController {
    private Google google;
    private ConnectionRepository connectionRepository;

    @Inject
    public WebController(Google google, ConnectionRepository connectionRepository) {
        this.google = google;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String sendHome(Model model) {
        if (connectionRepository.findPrimaryConnection(Google.class) == null) {
            return "redirect:/connect/google";
        }
        model.addAttribute("accessToken", google.getAccessToken());
        model.addAttribute("name", google.plusOperations().getGoogleProfile().getDisplayName());
        model.addAttribute("calendars", google.calendarOperations().getAllCalendars().getCalendars());
        return "home";
    }
}
