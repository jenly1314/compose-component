package com.king.compose.component.app.component.chart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.king.compose.component.chart.VerticalChartIndicator

/**
 * VerticalChartIndicator 示例
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
@Composable
fun VerticalChartIndicatorSample() {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        VerticalChartIndicator(
            values = listOf(0.3f),
            colors = listOf(Color.Green),
            modifier = Modifier
                .padding(16.dp)
                .height(300.dp),
            maxValue = 1f,
            strokeWidth = 8.dp,
        )
        VerticalChartIndicator(
            values = listOf(0.3f, 0.4f),
            colors = listOf(Color.Green, Color.Blue),
            modifier = Modifier
                .padding(16.dp)
                .height(300.dp)
                .clip(CircleShape),
            maxValue = 1f,
            strokeWidth = 8.dp,
        )
        VerticalChartIndicator(
            values = listOf(0.1f, 0.2f, 0.3f),
            colors = listOf(Color.Green, Color.Blue, Color.Yellow, Color.Cyan),
            modifier = Modifier
                .padding(16.dp)
                .height(300.dp),
            strokeWidth = 8.dp,
            cap = StrokeCap.Round,
        )
        VerticalChartIndicator(
            values = listOf(0.1f, 0.2f, 0.3f, 0.3f),
            colors = listOf(Color.Green, Color.Blue, Color.Yellow, Color.Cyan),
            modifier = Modifier
                .padding(16.dp)
                .height(300.dp),
            strokeWidth = 8.dp,
            cap = StrokeCap.Round,
            reverse = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun VerticalChartIndicatorSamplePreview() {
    VerticalChartIndicatorSample()
}