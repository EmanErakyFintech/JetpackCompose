package com.example.jetpackcompose.uis

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import com.example.jetpackcompose.R
import com.example.jetpackcompose.data.models.employees.EmployeeView
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EmployeeCard(
    onClickView: () -> Unit = {},
    onClickProduct: () -> Unit = {},
    employeeView: EmployeeView
) {
//    val constraintSet = ConstraintSet {
//        val guidLineEnd = createGuidelineFromEnd(16.dp)
//        val guideLineStart = createGuidelineFromStart(16.dp)
//        val guidelineTop = createGuidelineFromTop(32.dp)
//
//
//        val image = createRefFor("image")
//        val name = createRefFor("space")
//
//        val status = createRefFor("status")
//        val view = createRefFor("view")
//
//    }
    val status = if (employeeView.is_ban != false) {
        "مفعل حسابه"
    } else
        "مغلق حسابه"
    Card(onClick = onClickProduct, elevation = 0.dp) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clickable { onClickView.invoke()},
                painter = painterResource(R.drawable.ic_eye_2),
                contentDescription = "",
                alignment = Alignment.CenterStart,
            )

            Text(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1F),
                textAlign = TextAlign.Center, text = status
            )


            Text(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1F),
                textAlign = TextAlign.Start, text = employeeView.name.toString()
            )

            Image(
                painter = painterResource(R.drawable.ic_employee),
                modifier = Modifier.padding(end = 16.dp),
                contentDescription = "",
                alignment = Alignment.CenterEnd
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun HomeFragmentPreview() {
    JetpackComposeTheme {
//        EmployeeCard()
    }
}