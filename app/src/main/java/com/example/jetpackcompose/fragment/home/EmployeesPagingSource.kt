package com.example.jetpackcompose.fragment.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.jetpackcompose.data.models.employees.EmployeeView
import com.example.jetpackcompose.data.remotely.services.EmployeeService


class EmployeesPagingSource (private val requestService: EmployeeService,
                             private val token :String,
                             private val map: MutableMap<String, String>) : PagingSource<Int, EmployeeView>(){

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EmployeeView> {
        return try {
            val nextPage = params.key ?: 1
            map["per_page"] = "20"
            map["page"] = nextPage.toString()

            val branchListResponse = requestService.vendorEmployees(
                id =6,
                token = "Bearer $token",
                map = map)

            LoadResult.Page(
                data = branchListResponse.body()?.data?: arrayListOf(),
                prevKey = null ,
                nextKey = if (nextPage < (branchListResponse.body()?.meta?.last_page?:1))
                    nextPage.plus(1) else null
            )


        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, EmployeeView>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPageIndex = state.pages.indexOf(state.closestPageToPosition(anchorPosition))
            state.pages.getOrNull(anchorPageIndex + 1)?.prevKey ?: state.pages.getOrNull(
                anchorPageIndex - 1
            )?.nextKey
        }
    }

}