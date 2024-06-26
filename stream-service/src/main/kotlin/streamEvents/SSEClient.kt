package com.microservices.streamEvents

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import kotlinx.coroutines.flow.Flow

@Client("stream-wikimedia")
interface SSEClient {
    @Get("/v2/stream/recentchange")
    fun getStream(): Flow<Event>
}