package com.microservices.streamEvents

import jakarta.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
class WikiMediaEventsFacade(private val client: SSEClient) : EventsFacade {
    override fun getEvents(): Flow<Event> = client.getStream()
}