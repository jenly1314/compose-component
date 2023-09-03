package com.king.compose.component.app.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.king.compose.component.app.ComponentScreen
import com.king.compose.component.app.component.bar.SideBarSample
import com.king.compose.component.app.component.chart.CircularChartIndicatorSample
import com.king.compose.component.app.component.chart.HorizontalChartIndicatorSample
import com.king.compose.component.app.component.chart.VerticalChartIndicatorSample
import com.king.compose.component.app.component.text.TextFieldSample

/**
 * 导航图
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
fun NavGraphBuilder.navGraph(navController: NavController) {
    composable(route = Route.Components.name) {
        ComponentScreen(navController)
    }
    composable(route = Route.CircularChartIndicator.name) {
        CircularChartIndicatorSample()
    }
    composable(route = Route.HorizontalChartIndicator.name) {
        HorizontalChartIndicatorSample()
    }
    composable(route = Route.VerticalChartIndicator.name) {
        VerticalChartIndicatorSample()
    }
    composable(route = Route.TextField.name) {
        TextFieldSample()
    }
    composable(route = Route.SideBar.name) {
        SideBarSample()
    }
}