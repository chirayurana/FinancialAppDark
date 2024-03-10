package com.chirayu.financeapp.pages

import android.app.DatePickerDialog
import android.content.res.Configuration
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chirayu.financeapp.components.TableRow
import com.chirayu.financeapp.components.TextFieldUnstyled
import com.chirayu.financeapp.ui.theme.BackgroundElevated
import com.chirayu.financeapp.ui.theme.DividerColor
import com.chirayu.financeapp.ui.theme.FinanceAppTheme
import com.chirayu.financeapp.ui.theme.Primary
import com.chirayu.financeapp.ui.theme.Shapes
import com.chirayu.financeapp.ui.theme.TopAppBarBackground
import java.time.LocalDate
import java.util.Calendar
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Add(navController: NavController){
    val regularity = listOf(
        "None",
        "Daily",
        "Weekly",
        "Monthly",
        "Yearly"
    )
    var selectedRegularity by remember {
        mutableStateOf(regularity[0])
    }
    val categories = listOf("Education","Home","Personal","Hygiene")
    var selectedCategory by remember {
        mutableStateOf(categories[0])
    }
    //Adding Context
    val mContext = LocalContext.current
    //Defining Calender Parameter
    val calenderYear: Int
    val calenderMonth: Int
    val calenderDay: Int

    val mCalendar  = Calendar.getInstance()

    calenderYear = mCalendar.get(Calendar.YEAR)
    calenderMonth = mCalendar.get(Calendar.MONTH) + 1
    calenderDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    var mDate by remember {
        mutableStateOf("${mCalendar.get(Calendar.DAY_OF_MONTH)}-${mCalendar.get(Calendar.MONTH)+1}-${mCalendar.get(Calendar.YEAR)}")
    }

    val mDatePicker = DatePickerDialog(
        mContext,
        {
            _: DatePicker, selectedYear:Int, selectedMonth:Int, selectedDay:Int ->
            mDate = "${selectedDay}-${selectedMonth + 1}-${selectedYear}"
        },
        calenderYear,
        calenderMonth,
        calenderDay
        )
    //Setting Max Date
        mDatePicker.datePicker.maxDate = mCalendar.timeInMillis

    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text(text = "Add") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = TopAppBarBackground
                )
            )
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .clip(Shapes.large)
                        .background(BackgroundElevated)
                        .fillMaxWidth()
                ) {
                    //Amount Row
                    TableRow(label = "Amount") {
                        TextFieldUnstyled(
                            value = "Waa",
                            onValueChange = {},
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(textAlign = TextAlign.Right),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            )
                        )
                    }
                    Divider(
                        modifier = Modifier.padding(start = 16.dp),
                        thickness = 1.dp,
                        color = DividerColor
                    )
                    //Regularity Row
                    TableRow(label = "Regularity"){
                        var regularityMenuOpened by remember {
                            mutableStateOf(false)
                        }
                        TextButton(onClick = {regularityMenuOpened = true }, shape = Shapes.large) {

                            Text(selectedRegularity)
                            DropdownMenu(expanded = regularityMenuOpened , onDismissRequest = { regularityMenuOpened = false }) {
                                regularity.forEach{regularity ->
                                    DropdownMenuItem(text = { Text(text = regularity)},
                                        onClick = {
                                        selectedRegularity = regularity
                                        regularityMenuOpened = false
                                    })

                                }

                            }
                        }
                    }

                    Divider(
                        modifier = Modifier.padding(start = 16.dp),
                        thickness = 1.dp,
                        color = DividerColor
                    )
                    //Date Row
                    TableRow(label = "Date"){
                        TextButton(onClick = {mDatePicker.show()}) {
                            Text(mDate)
                        }

                    }
                    Divider(
                        modifier = Modifier.padding(start = 16.dp),
                        thickness = 1.dp,
                        color = DividerColor
                    )
                    //Notes Row
                    TableRow(label = "Note") {
                        TextFieldUnstyled(
                            value = "Umm",
                            onValueChange = {},
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(textAlign = TextAlign.Right),
                        )
                    }
                    Divider(
                        modifier = Modifier.padding(start = 16.dp),
                        thickness = 1.dp,
                        color = DividerColor
                    )

                    //Categories Row
                    TableRow(label = "Category"){
                        var categoryMenuOpened by remember {
                            mutableStateOf(false)
                        }
                        TextButton(onClick = {categoryMenuOpened = true }, shape = Shapes.large) {

                            Text(selectedCategory)
                            DropdownMenu(expanded = categoryMenuOpened , onDismissRequest = { categoryMenuOpened = false }) {
                                categories.forEach{category ->
                                    DropdownMenuItem(text =
                                    {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Surface(modifier = Modifier.size(10.dp), shape = CircleShape, color = Primary) {

                                        }
                                        Text(text = category, modifier = Modifier.padding(start = 8.dp))
                            
                                        }
                                    },
                                        onClick = {
                                            selectedCategory = category
                                            categoryMenuOpened = false
                                        })

                                }

                            }
                        }
                    }
                }
                //Adding Button
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(16.dp),
                    shape = Shapes.large
                ) {
                    Text(text = "Submit Expense")
                }
            }
        }
    )

}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAdd() {
    FinanceAppTheme {
        val navController = rememberNavController()
        Add(navController = navController)
    }
}