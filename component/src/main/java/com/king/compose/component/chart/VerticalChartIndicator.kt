package com.king.compose.component.chart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * 垂直图表指示器
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
 * @param reverse 是否反向绘制；默认为false，表示从上往下的顺序绘制；当设置为true时，则表示从下往上的顺序绘制
 */
@Composable
fun VerticalChartIndicator(
    values: List<Float>,
    colors: List<Color>,
    modifier: Modifier = Modifier,
    maxValue: Float = values.sum(),
    defaultColor: Color = Color.LightGray,
    strokeWidth: Dp = 4.dp,
    cap: StrokeCap = Stroke.DefaultCap,
    reverse: Boolean = false,
) {
    Box(modifier = modifier) {
        Canvas(
            modifier = Modifier
                .width(strokeWidth)
                .fillMaxHeight()
        ) {
            val thickness = size.width
            val offset = thickness.div(2)
            val totalSize = size.height
            drawLine(
                color = defaultColor,
                start = Offset(offset, 0f),
                end = Offset(offset, totalSize),
                strokeWidth = thickness,
                cap = cap,
            )
            val progressPercents = if (reverse) {
                -totalSize.div(maxValue)
            } else {
                totalSize.div(maxValue)
            }
            var lastEndProgress = if (reverse) {
                totalSize + values.sum().times(progressPercents)
            } else {
                values.sum().times(progressPercents)
            }
            var lastStartProgress: Float
            val len = values.size
            values.reversed().forEachIndexed { index, value ->
                lastStartProgress = lastEndProgress - value.times(progressPercents)
                if (value != 0f) {
                    drawLine(
                        color = colors.getOrElse(
                            index = len - index - 1,
                            defaultValue = { defaultColor }),
                        start = Offset(offset, lastStartProgress),
                        end = Offset(offset, lastEndProgress),
                        strokeWidth = thickness,
                        cap = cap
                    )
                }
                lastEndProgress = lastStartProgress
            }
        }
    }
}