package com.github.kevenvz.timetable.social;

import org.springframework.social.google.api.query.QueryBuilder;

import java.net.URI;

public interface UriQueryBuilder<Q extends UriQueryBuilder<?, T>, T> extends QueryBuilder<Q, T> {
    URI buildUri();
}
