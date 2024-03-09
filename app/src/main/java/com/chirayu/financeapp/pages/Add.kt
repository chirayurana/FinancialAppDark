package com.chirayu.financeapp.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.chirayu.financeapp.components.TableRow
import com.chirayu.financeapp.components.TextFieldUnstyled
import com.chirayu.financeapp.ui.theme.BackgroundElevated
import com.chirayu.financeapp.ui.theme.DividerColor
import com.chirayu.financeapp.ui.theme.Shapes
import com.chirayu.financeapp.ui.theme.TopAppBarBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Add(navController: NavController){
    Scaffold(
        topBar = {
            MediumTopAppBar(title = { Text(text = "Add") }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = TopAppBarBackground
            ))
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Column(modifier = Modifier
                    .padding(16.dp)
                    .clip(Shapes.large)
                    .background(BackgroundElevated)
                    .fillMaxWidth()
                ){
                    TableRow(label = "Amount"){
                        TextFieldUnstyled(
                            value = "Testt",
                            onValueChange ={},
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(textAlign = TextAlign.End),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            )
                        )
                        }
                    Divider(modifier = Modifier
                        .padding(start = 16.dp),thickness = 1.dp, color = DividerColor
                    )
                    TableRow(label = "Recurrence")
                    Divider(modifier = Modifier
                        .padding(start = 16.dp),thickness = 1.dp, color = DividerColor)
                    TableRow(label = "Date")
                    Divider(modifier = Modifier
                        .padding(start = 16.dp),thickness = 1.dp, color = DividerColor)
                    Divider(modifier = Modifier
                        .padding(start = 16.dp),thickness = 1.dp, color = DividerColor)
                    TableRow(label = "Note"){
                        TextFieldUnstyled(
                            value = "",
                            onValueChange ={},
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(textAlign = TextAlign.Right),
                        )
                    }
                    TableRow(label = "Category")






                }
            }
        }
    )
}

