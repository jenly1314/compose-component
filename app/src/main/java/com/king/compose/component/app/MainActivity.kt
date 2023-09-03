package com.king.compose.component.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.king.compose.component.app.navigation.Route
import com.king.compose.component.app.navigation.navGraph

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

/**
 * 主页
 */
@Composable
fun MainScreen() {
    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            val navController = rememberNavController()

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                var route = navController.currentBackStackEntryAsState().value?.destination?.route
                TopAppBar(backgroundColor = Color(0xFF3CDB84), title = {
                    Text(
                        text = route ?: Route.Components.name,
                        style = LocalTextStyle.current.copy(color = Color.White),
                    )
                })
            }
            NavHost(
                navController = navController,
                startDestination = Route.Components.name
            ) {
                navGraph(navController)
            }
        }
    }
}

/**
 * 组件列表页
 */
@Composable
fun ComponentScreen(navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(Route.values().filter { it != Route.Components }) {
            Text(
                text = it.name,
                style = LocalTextStyle.current.copy(color = Color.DarkGray),
                modifier = Modifier
                    .fillParentMaxWidth()
                    .clickable {
                        navController.navigate(route = it.name)
                    }
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            )
            Divider(modifier = Modifier.padding(horizontal = 16.dp), thickness = 0.5.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}