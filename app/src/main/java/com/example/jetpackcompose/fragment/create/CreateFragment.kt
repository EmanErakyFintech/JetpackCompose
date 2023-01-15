package com.example.jetpackcompose.fragment.create

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.uis.Indicator
import com.example.jetpackcompose.uis.QuantityMenuSpinner

@Composable
fun CreateFragment() {

    val name = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val identity = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }

    val constrainSet = ConstraintSet {
        val guidLineEnd = createGuidelineFromEnd(16.dp)
        val guideLineStart = createGuidelineFromStart(16.dp)
        val guidelineTop = createGuidelineFromTop(32.dp)


        val indicator = createRefFor("indicator")
        val space = createRefFor("space")

        val txtName = createRefFor("txtName")
        val edtName = createRefFor("nameEmployee")


        val txtPhone = createRefFor("txtPhone")
        val edtPhone = createRefFor("edtPhone")

        val txtIdentity = createRefFor("txtIdentity")
        val edtIdentity = createRefFor("edtIdentity")

        val txtEmail = createRefFor("txtEmail")
        val edtEmail = createRefFor("edtEmail")

        val txtNationality = createRefFor("txtNationality")
        val spNationality = createRefFor("spNationality")

        constrain(indicator) {
            top.linkTo(guidelineTop)
            start.linkTo(guideLineStart)
            end.linkTo(guidLineEnd)
            width = Dimension.fillToConstraints
        }
        constrain(space) {
            top.linkTo(indicator.bottom)
            start.linkTo(guideLineStart)
            end.linkTo(guidLineEnd)
            height =Dimension.value(32.dp)
            width = Dimension.fillToConstraints
        }


        constrain(txtName) {
            top.linkTo(space.bottom)
            start.linkTo(guideLineStart)
            end.linkTo(guidLineEnd)
            height = Dimension.value(50.dp)
            width = Dimension.fillToConstraints
        }

        constrain(edtName) {
            top.linkTo(txtName.bottom)
            start.linkTo(guideLineStart)
            end.linkTo(guidLineEnd)
            height = Dimension.value(50.dp)
            width = Dimension.fillToConstraints
        }
        constrain(txtPhone) {
            top.linkTo(edtName.bottom)
            start.linkTo(guideLineStart)
            end.linkTo(guidLineEnd)
            height = Dimension.value(50.dp)
            width = Dimension.fillToConstraints
        }
        constrain(edtPhone) {
            top.linkTo(txtPhone.bottom)
            start.linkTo(guideLineStart)
            end.linkTo(guidLineEnd)
            height = Dimension.value(50.dp)
            width = Dimension.fillToConstraints
        }
        constrain(txtIdentity) {
            top.linkTo(edtPhone.bottom)
            start.linkTo(guideLineStart)
            end.linkTo(guidLineEnd)
            height = Dimension.value(50.dp)
            width = Dimension.fillToConstraints
        }
        constrain(edtIdentity) {
            top.linkTo(txtIdentity.bottom)
            start.linkTo(guideLineStart)
            end.linkTo(guidLineEnd)
            height = Dimension.value(50.dp)
            width = Dimension.fillToConstraints
        }

        constrain(txtEmail) {
            top.linkTo(edtIdentity.bottom)
            start.linkTo(guideLineStart)
            end.linkTo(guidLineEnd)
            height = Dimension.value(50.dp)
            width = Dimension.fillToConstraints
        }
        constrain(edtEmail) {
            top.linkTo(txtEmail.bottom)
            start.linkTo(guideLineStart)
            end.linkTo(guidLineEnd)
            height = Dimension.value(50.dp)
            width = Dimension.fillToConstraints
        }

        constrain(txtNationality) {
            top.linkTo(edtEmail.bottom)
            start.linkTo(guideLineStart)
            end.linkTo(guidLineEnd)
            height = Dimension.value(50.dp)
            width = Dimension.fillToConstraints
        }
        constrain(spNationality) {
            top.linkTo(txtNationality.bottom)
            start.linkTo(guideLineStart)
            end.linkTo(guidLineEnd)
            height = Dimension.value(50.dp)
            width = Dimension.fillToConstraints
        }

    }

    ConstraintLayout(
        constraintSet = constrainSet, modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white))
    ) {

        Indicator()

        Spacer(modifier = Modifier.layoutId("space"))

        TitleText("Employee Name", "txtName")

        Box(
            modifier = Modifier
                .layoutId("nameEmployee")
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.colorBackground),
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
                .background(color = colorResource(id = R.color.colorBackground))
        ) {
            TextField(
                value = name.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                onValueChange = { name.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Employee Name",
                        fontSize = 14.sp,
                        modifier = Modifier.fillMaxWidth(),
                        color = colorResource(id = R.color.colorHint),
                    )
                },

                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorResource(id = R.color.colorBackground),
                    textColor = colorResource(id = R.color.colorPrimary),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = colorResource(id = R.color.colorPrimary),
                )
            )

        }

        TitleText("Phone Number", "txtPhone")


        Box(
            modifier = Modifier
                .layoutId("edtPhone")
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.colorBackground),
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
        ) {
            TextField(
                value = phone.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { phone.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "phone Number",
                        fontSize = 14.sp,
                        modifier = Modifier.fillMaxWidth(),
                        color = colorResource(id = R.color.colorHint),
                    )
                },

                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorResource(id = R.color.colorBackground),
                    textColor = colorResource(id = R.color.colorPrimary),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = colorResource(id = R.color.colorPrimary),
                )
            )

        }


        TitleText("Identity Number", "txtIdentity")


        Box(
            modifier = Modifier
                .layoutId("edtIdentity")
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.colorBackground),
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
        ) {
            TextField(
                value = identity.value,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                onValueChange = { identity.value = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Identity Number",
                        fontSize = 14.sp,
                        modifier = Modifier.fillMaxWidth(),
                        color = colorResource(id = R.color.colorHint),
                    )
                },

                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorResource(id = R.color.colorBackground),
                    textColor = colorResource(id = R.color.colorPrimary),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = colorResource(id = R.color.colorPrimary),
                )
            )

        }

        TitleText("Email Address", "txtEmail")
        Box(
            modifier = Modifier
                .layoutId("edtEmail")
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.colorBackground),
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
        ) {
            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Email Address",
                        fontSize = 14.sp,
                        modifier = Modifier.fillMaxWidth(),
                        color = colorResource(id = R.color.colorHint),
                    )
                },

                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = colorResource(id = R.color.colorBackground),
                    textColor = colorResource(id = R.color.colorPrimary),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    cursorColor = colorResource(id = R.color.colorPrimary),
                )
            )

        }
        TitleText("Nationality", "txtNationality")

        QuantityMenuSpinner()

    }
}

@Composable
fun TitleText(title: String, id: String) {
    Text(
        text = title,
        color = colorResource(id = R.color.colorBlack),
        fontSize = 16.sp,
        modifier = Modifier
            .layoutId(id)
            .padding(top = 15.dp)

    )
}

@Preview(showBackground = true)
@Composable
fun HomeFragmentPreview() {
    JetpackComposeTheme {
        CreateFragment()
    }
}