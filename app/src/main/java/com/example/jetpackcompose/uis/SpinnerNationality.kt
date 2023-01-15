package com.example.jetpackcompose.uis

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun QuantityMenuSpinner() {
    val options = listOf("Nationality","Food", "Bill Payment", "Recharges", "Outing", "Other")

    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = Modifier
            .layoutId("spNationality")
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.colorBackground),
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.White)

    ) {
        TextField(
            readOnly = true,
            value = selectedOptionText,
            onValueChange = { },
//            label = { Text("Categories") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.colorBackground),
                textColor = colorResource(id = R.color.colorPrimary),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = colorResource(id = R.color.colorPrimary),
            ),
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    }
                ) {
                    Text(text = selectionOption ,)
                }
            }
        }
    }
}