package com.example.jetpackcompose.fragment.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.jetpackcompose.data.models.employees.EmployeeView
import com.example.jetpackcompose.data.repository.EmployeeRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryEmployeeViewModel(private val repository: EmployeeRepositoryImpl) : ViewModel() {
    private var _data: MutableSharedFlow<PagingData<EmployeeView>>? = MutableSharedFlow()
    var data: Flow<PagingData<EmployeeView>>? = _data?.cachedIn(viewModelScope)

    internal val intent = Channel<EmployeeIntent>(Channel.UNLIMITED)


    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            intent.consumeAsFlow().collect {
                when (it) {
                    is EmployeeIntent.CallEmployees -> {
                        callEmployees(it.token, it.map)
                    }
                }
            }
        }
    }


    fun onEvent(event: UIEvent) {
        when (event) {
            is UIEvent.Send -> {
                viewModelScope.launch {
                    intent.send(EmployeeIntent.CallEmployees(
                            "1346|di0P54pPK3X9dZQCSXWytLRrEFKIr7vlyo4OK9Z1",
                            mutableMapOf()
                        )
                    )
                }
            }
        }
    }

    private fun callEmployees(token: String, map: MutableMap<String, String>) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                repository.vendorEmployees(token, map = map).collect {
                    _data?.emit(it)
                }
            }

        }
    }


}