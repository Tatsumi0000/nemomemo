package love.aespa.nemomemo.feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class NemomemoViewModel: ViewModel() {
    data class UiState(
        val text: String = ""
    )
    sealed interface UiEvent {
        data object Empty : UiEvent
    }
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
    private val _event = Channel<UiEvent>()
    val event: Flow<UiEvent> = _event.receiveAsFlow()

    init {
        viewModelScope.launch {
//            Do something...
        }
    }
}