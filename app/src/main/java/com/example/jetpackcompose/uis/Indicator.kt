package com.example.jetpackcompose.uis

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme


@Composable
fun TitleIndicator(title: String, id: String) {
    Text(
        text = title,
        textAlign = TextAlign.Center,
        color = colorResource(id = R.color.colorLightGray),
        fontSize = 16.sp,
        modifier = Modifier
            .layoutId(id)
            .padding(top = 15.dp)

    )
}
@Composable
fun Indicator() {
    val constraintSet = ConstraintSet {

        val guideLineTop =createGuidelineFromTop(32.dp)
        val guidLineEnd = createGuidelineFromEnd(16.dp)
        val guideLineStart = createGuidelineFromStart(16.dp)

        val imgPersonal = createRefFor("personal")
        val txtPersonal = createRefFor("txtPersonal")

        val lineOne = createRefFor("lineOne")

        val imgJob = createRefFor("job")
        val txtJob = createRefFor("txtJob")

        val lineSecond = createRefFor("lineSecond")

        val imgPermission = createRefFor("permission")
        val txtPermission = createRefFor("txtPermission")

        constrain(imgPersonal) {
            top.linkTo(guideLineTop)
            start.linkTo(txtPersonal.start)
            end.linkTo(txtPersonal.end)
            width = Dimension.fillToConstraints
        }
        constrain(txtPersonal) {
            top.linkTo(imgPersonal.bottom)
            start.linkTo(guideLineStart)
            end.linkTo(txtJob.start)
            width = Dimension.fillToConstraints
        }

        constrain(lineOne) {
            top.linkTo(imgPersonal.top)
            bottom.linkTo(imgPersonal.bottom)
            start.linkTo(imgPersonal.end)
            end.linkTo(imgJob.start)
        }
        constrain(imgJob) {
            top.linkTo(guideLineTop)
            start.linkTo(txtJob.start)
            end.linkTo(txtJob.end)
            width = Dimension.fillToConstraints
        }
        constrain(txtJob) {
            top.linkTo(imgJob.bottom)
            start.linkTo(txtPersonal.end)
            end.linkTo(txtPermission.start)
            width = Dimension.fillToConstraints
        }

        constrain(lineSecond) {
            top.linkTo(imgPersonal.top)
            bottom.linkTo(imgPersonal.bottom)
            start.linkTo(imgJob.end)
            end.linkTo(imgPermission.start)
        }
        constrain(imgPermission) {
            top.linkTo(guideLineTop)
            start.linkTo(txtPermission.start)
            end.linkTo(txtPermission.end)
            width = Dimension.fillToConstraints
        }
        constrain(txtPermission) {
            top.linkTo(imgPermission.bottom)
            start.linkTo(txtJob.end)
            end.linkTo(guidLineEnd)
            width = Dimension.fillToConstraints
        }
        createHorizontalChain(imgPersonal, imgJob, imgPermission, chainStyle = ChainStyle.Spread)
        createHorizontalChain(txtPersonal, txtJob, txtPermission, chainStyle = ChainStyle.Spread)

    }

    ConstraintLayout(
        constraintSet = constraintSet, modifier = Modifier
            .fillMaxWidth()
            .background(
                color = colorResource(
                    id = R.color.white
                )
            )
    ) {


        TitleIndicator("Personal", "txtPersonal")


        Image(
            painter = painterResource(id = R.drawable.ic_administrator_data),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier
                .layoutId("personal")
        )

        Divider(
            color = colorResource(id = R.color.colorLightGray),
            thickness = 1.dp,
            modifier = Modifier
                .layoutId("lineOne")
                .width(90.dp)
        )

        TitleIndicator("Job", "txtJob")

        Image(
            painter = painterResource(id = R.drawable.ic_company_data),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier
                .layoutId("job")
        )

        Divider(
            color = colorResource(id = R.color.colorLightGray),
            thickness = 1.dp,
            modifier = Modifier
                .layoutId("lineSecond")
                .width(90.dp)
        )

        TitleIndicator("Permission", "txtPermission")

        Image(
            painter = painterResource(id = R.drawable.ic_administrator_data),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier
                .layoutId("permission")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    JetpackComposeTheme {
        Indicator()
    }
}