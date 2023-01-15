package com.example.jetpackcompose.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.jetpackcompose.data.models.employees.EmployeeView
import com.example.jetpackcompose.data.remotely.services.EmployeeService
import com.example.jetpackcompose.fragment.home.EmployeesPagingSource
import com.example.jetpackcompose.utils.UiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface EmployeeRepository {
    suspend fun vendorEmployees(
        token: String,
        map: MutableMap<String, String>
    ): Flow<PagingData<EmployeeView>>

    suspend fun viewEmployee(employeeId: Int, token: String): Flow<UiResult<EmployeeView>>
}

class EmployeeRepositoryImpl(private val employeeService: EmployeeService) : EmployeeRepository {
    override suspend fun vendorEmployees(
        token: String,
        map: MutableMap<String, String>
    ): Flow<PagingData<EmployeeView>> {
        return Pager(config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { EmployeesPagingSource(employeeService, token, map) }).flow

    }

    override suspend fun viewEmployee(
        employeeId: Int,
        token: String
    ): Flow<UiResult<EmployeeView>> = flow {
        emit(UiResult.Loading)
        val result = try {
            val value =
                employeeService.viewEmployee(employeeId = employeeId, token = "Bearer $token")
            UiResult.Success(value)
        } catch (e: Throwable) {
            UiResult.Error(e.toString())
        }
        emit(result)
    }


}