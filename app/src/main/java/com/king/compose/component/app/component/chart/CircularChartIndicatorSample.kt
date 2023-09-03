package com.king.compose.component.app.component.chart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.king.compose.component.chart.CircularChartIndicator

/**
 * CircularChartIndicator 示例
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
@Composable
fun CircularChartIndicatorSample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        CircularChartIndicator(
            values = listOf(0.3f),
            colors = listOf(Color.Green),
            modifier = Modifier
                .padding(16.dp)
                .size(160.dp),
            maxValue = 1f,
        )
        CircularChartIndicator(
            values = listOf(0.1f, 0.2f, 0.3f, 0.3f),
            colors = listOf(Color.Green, Color.Blue, Color.Yellow, Color.Cyan),
            modifier = Modifier
                .padding(16.dp)
                .size(160.dp),
        )
        CircularChartIndicator(
            values = listOf(0.1f, 0.2f, 0.3f, 0.3f),
            colors = listOf(Color.Green, Color.Blue, Color.Yellow, Color.Cyan),
            modifier = Modifier
                .padding(16.dp)
                .size(160.dp),
            strokeWidth = 80.dp,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CircularChartIndicatorSamplePreview() {
    CircularChartIndicatorSample()
}