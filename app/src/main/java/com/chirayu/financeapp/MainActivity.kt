package com.chirayu.financeapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chirayu.financeapp.pages.Expenses
import com.chirayu.financeapp.pages.Settings
import com.chirayu.financeapp.ui.theme.FinanceAppTheme
import com.chirayu.financeapp.ui.theme.TopAppBarBackground

class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
        FinanceAppTheme {
            val navController = rememberNavController()
            val backStackEntry = navController.currentBackStackEntryAsState()
            Scaffold(
                bottomBar = {
                        NavigationBar(containerColor = TopAppBarBackground) {
                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route == "expenses",
                                onClick = { navController.navigate("expenses") },
                                label = {
                                    Text("Expenses")
                                },
                                icon = {
                                    Icon(
                                        painterResource(id = R.drawable.baseline_upload_24),
                                        contentDescription = "Upload"
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route == "reports",
                                onClick = { navController.navigate("reports") },
                                label = {
                                    Text("Reports")
                                },
                                icon = {
                                    Icon(
                                        painterResource(id = R.drawable.bar_chart),
                                        contentDescription = "Bar Chart"
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route == "add",
                                onClick = { navController.navigate("add") },
                                label = {
                                    Text("Add")
                                },
                                icon = {
                                    Icon(
                                        painterResource(id = R.drawable.add),
                                        contentDescription = "Add"
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = backStackEntry.value?.destination?.route?.startsWith("settings")?:false ,
                                onClick = { navController.navigate("settings") },
                                label = {
                                    Text("Settings")
                                },
                                icon = {
                                    Icon(
                                        painterResource(id = R.drawable.settings),
                                        contentDescription = "Settings"
                                    )
                                }
                            )
                        }
                    },
                //Setting up Nav Host and route
                content = { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "expenses"
                        ){
                        composable("expenses"){
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding)
                            ) {
                                Expenses(navController,"Chirayu")
                            }
                        }
                        composable("reports"){
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding)
                            ) {
                                Greeting(name = "Reports")
                            }
                        }
                        composable("add"){
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding)
                            ) {
                                Greeting(name = "Add")
                            }
                        }
                        composable("settings"){
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding)
                            ) {
                                Settings(navController)
                            }
                        }
                        composable("settings/categories"){
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding)
                            ) {
                                Greeting(name = "Categories")
                            }
                        }
                    }
                }
                )
            }
        }
    }
}

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
    @Composable
    fun GreetingPreview() {
        FinanceAppTheme {
            Surface {
                Greeting("Android")
            }
        }
    }

