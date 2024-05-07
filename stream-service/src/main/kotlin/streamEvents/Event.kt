package com.microservices.streamEvents

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Event(
    private val id: Long,
    private val meta: Meta,
    @JsonProperty("title_url")
    private val titleUrl: String,
)

@Serdeable
data class Meta(
    private val dt: String,
    private val stream: String,
)