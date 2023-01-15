package com.example.jetpackcompose.fragment.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.data.models.employees.EmployeeView
import com.example.jetpackcompose.data.repository.EmployeeRepositoryImpl
import com.example.jetpackcompose.utils.UiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewEmployeeViewModel(private val repositoryImpl: EmployeeRepositoryImpl) : ViewModel() {

    internal val intent = Channel<ViewEmployeeIntent>(Channel.UNLIMITED)
//    private val _dataObserve = MutableStateFlow<UiResult<EmployeeView>>(UiResult.Idle)
//    val dataObserver = _dataObserve.asStateFlow()



    private val _dataObserve = mutableStateOf<UiResult<EmployeeView>>(UiResult.Success(null))
    val dataObserver: State<UiResult<EmployeeView>> = _dataObserve

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intent.consumeAsFlow().collect {
                when (it) {
                    is ViewEmployeeIntent.CallViewEmployee -> {
                        callViewEmployee(it.id, it.token)
                    }

                }
            }
        }
    }

    private fun callViewEmployee(employeeId: Int, token: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repositoryImpl.viewEmployee(employeeId, token).collect {
                    _dataObserve.value =(it)
                }
            }
        }
    }

    fun onEvent(event: UIEventDetail) {
        when (event) {
            is UIEventDetail.SendId -> {
                viewModelScope.launch {
                    intent.send(
                        ViewEmployeeIntent.CallViewEmployee(
                            id = event.id,
                            token = event.token
                        )
                    )
                }
            }
        }
    }

}