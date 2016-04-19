package com.github.kevenvz.timetable.social.calendar;

import com.github.kevenvz.timetable.social.UriQueryBuilder;
import org.springframework.social.google.api.query.impl.QueryBuilderImpl;

import java.net.URI;
import java.net.URISyntaxException;

public abstract class UriQueryBuilderImpl<Q extends UriQueryBuilder<?, T>, T> extends QueryBuilderImpl<Q, T> implements UriQueryBuilder<Q, T> {

    public UriQueryBuilderImpl(String urlTemplate) {
        super(urlTemplate);
    }

    public URI buildUri() {
        try {
            return new URI(super.build());
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }
}
