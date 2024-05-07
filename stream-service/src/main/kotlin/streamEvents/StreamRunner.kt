package com.microservices.streamEvents

import io.micronaut.context.event.StartupEvent
import io.micronaut.runtime.event.annotation.EventListener
import jakarta.inject.Singleton
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Singleton
class StreamRunner (private val sseClient: SSEClient) {
    @OptIn(DelicateCoroutinesApi::class)
    @EventListener
    fun onServiceReady(serviceReadyEvent: StartupEvent) {
        GlobalScope.launch {
            sseClient.getStream().collect {
                println("New message.")
                it.entries.forEach { item ->
                    println("key [${item.key}] value [${item.value}]")
                }
            }
        }
    }
}