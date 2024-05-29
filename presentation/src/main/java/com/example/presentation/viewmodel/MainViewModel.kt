package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DomainLoveResponse
import com.example.domain.usecase.CheckLoveCalculatorUseCase
import com.example.domain.utils.ErrorType
import com.example.domain.utils.RemoteErrorEmitter
import com.example.domain.utils.ScreenState
import com.example.presentation.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val checkLoveCalculatorUseCase: CheckLoveCalculatorUseCase
): ViewModel(), RemoteErrorEmitter {

    val apiCallEvent: LiveData<ScreenState> get() = _apiCallEvent
    private var _apiCallEvent = SingleLiveEvent<ScreenState>()

    var apiCallResult = DomainLoveResponse("","", 0, "")
    var apiErrorType = ErrorType.UNKNOWN
    var apiErrorMessage = "none"
    var manNameResult = "man"
    var womanNameResult = "woman"

    fun checkLoveCalulator(
        host: String,
        key: String,
        sname: String,
        fname: String
    ) = viewModelScope.launch {
        checkLoveCalculatorUseCase.execute(this@MainViewModel, host, key, sname, fname)
            .let { response ->
                if(response != null) { // 반환값이 null이 아닐 때
                    apiCallResult = response
                    _apiCallEvent.postValue(ScreenState.LOADING)
                } else { // 반환값이 null일 때
                    _apiCallEvent.postValue(ScreenState.ERROR)
                }
            }
    }

    override fun onError(msg: String) {
        apiErrorMessage = msg
    }

    override fun onError(errorType: ErrorType) {
        apiErrorType = errorType
    }
}