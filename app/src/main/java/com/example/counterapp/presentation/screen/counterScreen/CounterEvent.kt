package com.example.counterapp.presentation.screen.counterScreen

sealed interface CounterEvent {
    object Increment: CounterEvent
    object Decrement: CounterEvent
    object Reset: CounterEvent
}