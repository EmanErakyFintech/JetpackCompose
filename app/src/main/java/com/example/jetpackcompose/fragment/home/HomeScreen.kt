package com.example.jetpackcompose.fragment.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.example.jetpackcompose.data.models.employees.EmployeeView
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.uis.EmployeeCard
import com.example.jetpackcompose.uis.ProductCard


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClickToCreateScreen: () -> Unit = {},
    onClickToDetailScreen: (Int) -> Unit = {},
    employeeList: LazyPagingItems<EmployeeView>
) {
    LazyColumn(
        modifier = modifier.padding(16.dp),
//        columns = GridCells.Adaptive(minSize = 96.dp),
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(employeeList.itemCount) { index ->
            employeeList[index].let { employee ->
                val id = employee?.id
                EmployeeCard(onClickView = onClickToCreateScreen,onClickProduct = { onClickToDetailScreen.invoke(id!!) }, employeeView = employee!!)
            }
        }
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreview() {
    JetpackComposeTheme {
//        HomeScreen()
    }
}