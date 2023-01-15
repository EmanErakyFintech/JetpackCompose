package com.example.jetpackcompose.fragment.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeFragment(
    modifier: Modifier = Modifier,
    onClickToCreateScreen: () -> Unit = {},
    onClickToDetailScreen: (Int) -> Unit = {},
    vm: HistoryEmployeeViewModel = getViewModel()
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        vm.onEvent(UIEvent.Send)

        observeEmployees(vm,onClickToCreateScreen=onClickToCreateScreen,onClickToDetailScreen = onClickToDetailScreen)
    }
}


@Composable
private fun observeEmployees(
    vm: HistoryEmployeeViewModel,
    onClickToDetailScreen: (Int) -> Unit = {},
    onClickToCreateScreen: () -> Unit = {}
) {

    vm.data?.collectAsLazyPagingItems()
        ?.let {
            HomeScreen(
                onClickToCreateScreen = onClickToCreateScreen,
                onClickToDetailScreen = onClickToDetailScreen,
                employeeList = it
            )
        }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeFragmentPreview() {
    JetpackComposeTheme {
        HomeFragment()
    }
}
