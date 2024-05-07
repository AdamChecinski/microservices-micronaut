package com.microservices.streamEvents

import kotlinx.coroutines.flow.Flow

interface EventsFacade {
    fun getEvents(): Flow<Event>
}