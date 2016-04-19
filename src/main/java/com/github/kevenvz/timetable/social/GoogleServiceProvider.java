package com.github.kevenvz.timetable.social;

import com.github.kevenvz.timetable.social.impl.GoogleTemplate;
import org.springframework.social.google.connect.GoogleOAuth2Template;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

public class GoogleServiceProvider extends AbstractOAuth2ServiceProvider<Google> {
    public GoogleServiceProvider(String clientId, String clientSecret) {
        super(new GoogleOAuth2Template(clientId, clientSecret));
    }

    public Google getApi(String accessToken) {
        return new GoogleTemplate(accessToken);
    }
}
