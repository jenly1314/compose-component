package com.king.compose.component.chart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * 圆形图表指示器
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 *
 * @param values 图表中的值
 * @param colors 图表中的值对应的颜色
 * @param modifier [Modifier]
 * @param maxValue 最大值；默认为：[values]的总和
 * @param defaultColor 默认颜色
 * @param strokeWidth 画笔宽度
 * @param cap 画笔结尾的样式
 * @param reverse 是否反向绘制；默认为false，表示顺时针绘制；当设置为true时，则表示逆时针绘制
 */
@Composable
fun CircularChartIndicator(
    values: List<Float>,
    colors: List<Color>,
    modifier: Modifier = Modifier,
    maxValue: Float = values.sum(),
    defaultColor: Color = Color.LightGray,
    strokeWidth: Dp = 16.dp,
    cap: StrokeCap = Stroke.DefaultCap,
    startAngle: Float = Angle.DefaultStartAngle,
    sweepAngle: Float = Angle.DefaultSweepAngle,
    reverse: Boolean = false,
    contentAlignment: Alignment = Alignment.TopStart,
) {
    Box(modifier = modifier, contentAlignment = contentAlignment) {
        val anglePercents by remember(reverse, maxValue) {
            derivedStateOf {
                if (reverse) {
                    -sweepAngle.div(maxValue)
                } else {
                    sweepAngle.div(maxValue)
                }
            }
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            val style = Stroke(width = strokeWidth.toPx(), cap = cap)
            val offset = style.width.div(2)
            val topLeft = Offset(offset, offset)
            val diameter = size.minDimension.minus(style.width)
            val arcSize = Size(diameter, diameter)
            drawArc(
                color = defaultColor,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                topLeft = topLeft,
                size = arcSize,
                style = style
            )
            var lastStartAngle = startAngle
            var lastSweepAngle: Float
            values.forEachIndexed { index, value ->
                lastSweepAngle = value.times(anglePercents)
                if (lastSweepAngle != 0f) {
                    drawArc(
                        color = colors.getOrElse(index = index, defaultValue = { defaultColor }),
                        startAngle = lastStartAngle,
                        sweepAngle = lastSweepAngle,
                        useCenter = false,
                        topLeft = topLeft,
                        size = arcSize,
                        style = style
                    )
                }
                lastStartAngle += lastSweepAngle
            }
        }
    }
}

/**
 * 角度
 */
internal object Angle {
    const val DefaultStartAngle = 270f
    const val DefaultSweepAngle = 360f
}
