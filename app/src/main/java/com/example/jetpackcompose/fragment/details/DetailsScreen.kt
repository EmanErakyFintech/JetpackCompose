package com.example.jetpackcompose.fragment.details

import android.content.res.Configuration
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.data.models.employees.EmployeeView
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.uis.ProductHeader
import com.example.jetpackcompose.uis.ProductImageCarousel


@Composable
fun DetailsScreen(modifier: Modifier = Modifier,employeeView: EmployeeView?=null) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {

        ProductHeader()
        ProductImageCarousel(
            modifier = modifier
                .height(200.dp)
                .fillMaxWidth()
        )
        Text(
            text = employeeView?.name.toString(),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(
                top = 16.dp,
            )
        )
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreview() {
    JetpackComposeTheme {
        DetailsScreen()
    }
}