package com.microservices.streamEvents

import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import jakarta.inject.Singleton
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

@Singleton
class StreamRunner (private val eventsFacade: EventsFacade) {
    @OptIn(DelicateCoroutinesApi::class)
    @EventListener
    fun onServiceReady(serviceReadyEvent: StartupEvent) {
        GlobalScope.launch {
            eventsFacade.getEvents().collect {
                logger.info { "New message" }
                logger.info { it }
            }
        }
    }
}