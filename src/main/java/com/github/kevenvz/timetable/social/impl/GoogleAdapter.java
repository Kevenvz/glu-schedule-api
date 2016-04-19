package com.github.kevenvz.timetable.social.impl;

import com.github.kevenvz.timetable.social.Google;
import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.google.api.plus.Person;

public class GoogleAdapter implements ApiAdapter<Google> {

    public boolean test(Google google) {
        try {
            google.plusOperations().getGoogleProfile();
            return true;
        } catch (ApiException e) {
            return false;
        }
    }

    public void setConnectionValues(Google google, ConnectionValues values) {
        Person profile = google.plusOperations().getGoogleProfile();
        values.setProviderUserId(profile.getId());
        values.setDisplayName(profile.getDisplayName());
        values.setProfileUrl(profile.getUrl());
        values.setImageUrl(profile.getImageUrl());
    }

    public UserProfile fetchUserProfile(Google google) {
        Person profile = google.plusOperations().getGoogleProfile();
        return new UserProfileBuilder().setUsername(profile.getId())
                .setEmail(profile.getAccountEmail())
                .setName(profile.getDisplayName())
                .setFirstName(profile.getGivenName())
                .setLastName(profile.getFamilyName()).build();
    }

    public void updateStatus(Google google, String message) {
        throw new UnsupportedOperationException();
    }

}
