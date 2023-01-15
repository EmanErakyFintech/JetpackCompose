package com.example.jetpackcompose.fragment.details

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.utils.UiResult
import org.koin.androidx.compose.getViewModel


@Composable
fun DetailsFragment(id: Int = -1, viewModel: ViewEmployeeViewModel = getViewModel()) {

    fun launch(){
        viewModel.onEvent(UIEventDetail.SendId(id, "1346|di0P54pPK3X9dZQCSXWytLRrEFKIr7vlyo4OK9Z1"))
    }

    launch()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        ObserveEmployee(viewModel)
    }
}


@Composable
private fun ObserveEmployee(vm: ViewEmployeeViewModel) {
    when (val repo = vm.dataObserver.value) {
        is UiResult.Success -> {
            if (repo.data != null)
                DetailsScreen(employeeView = repo.data)
        }
        else -> {}
    }

}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DetailsFragmentPreview() {
    JetpackComposeTheme {
        DetailsFragment()
    }
}