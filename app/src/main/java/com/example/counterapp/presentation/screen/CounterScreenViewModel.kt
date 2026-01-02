package com.example.counterapp.presentation.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.counterapp.presentation.screen.counterScreen.CounterEvent
import com.example.counterapp.presentation.screen.counterScreen.CounterState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class CounterScreenViewModel @Inject constructor(): ViewModel() {
    var state by mutableStateOf(CounterState())
        private set

    fun onEvent(event: CounterEvent) {
        when(event) {
            CounterEvent.Decrement -> { state = state.copy(counter = state.counter + 1) }
            CounterEvent.Increment -> { state = state.copy(counter = state.counter - 1) }
            CounterEvent.Reset -> resetCounter()
            // yaha else dinu parena becuase event is sealed
            //compiler knows all possible cases because of sealed interface
        }
    }

    private fun resetCounter() {
        viewModelScope.launch(Dispatchers.Unconfined) {
            delay(5000)
            state = state.copy(counter = 0)
        }
    }
}


































