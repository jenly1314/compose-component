package com.king.compose.component.bar

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

/**
 * 字母索引侧边栏
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 *
 * @param modifier [Modifier]
 * @param chars 字母字符索引列表
 * @param bubbleTip 滑动选中时的气泡提示
 * @param itemContent 字母索引对应的Item内容
 * @param onSelectedChange 当字母索引选中发生改变时触发此函数
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SideBar(
    modifier: Modifier = Modifier,
    chars: CharArray = defaultChars,
    bubbleTip: @Composable BoxScope.(Char) -> Unit = {
        SideBarBubbleTip(it)
    },
    itemContent: @Composable ColumnScope.(Char, Boolean) -> Unit = { char, selected ->
        SideBarItemContent(char, selected)
    },
    onSelectedChange: (Char) -> Unit = {},
) {
    var lastChars by remember(chars) { mutableStateOf(chars) }
    var selectedPosition by remember { mutableStateOf<Int?>(null) }
    var selectedChar by remember { mutableStateOf<Char?>(null) }
    var sideBarSize by remember { mutableStateOf(IntSize.Zero) }
    var charSize by remember { mutableStateOf(IntSize.Zero) }

    Box(modifier = modifier, contentAlignment = Alignment.TopEnd) {
        Column(modifier = Modifier
            .onSizeChanged {
                sideBarSize = it
            }
            .pointerInteropFilter {
                if (sideBarSize.height > 0) {
                    when (it.action) {
                        MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                            val position = it.y
                                .div(sideBarSize.height)
                                .times(lastChars.size)
                                .roundToInt()
                                .coerceAtLeast(0)
                                .coerceAtMost(lastChars.lastIndex)
                            val char = lastChars[position]
                            selectedPosition = position

                            val charChangedSinceLastInvocation = selectedChar != char
                            selectedChar = char
                            if (charChangedSinceLastInvocation) {
                                onSelectedChange(char)
                            }
                        }

                        MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                            selectedChar = null
                            selectedPosition = null
                        }
                    }
                }
                true
            }) {
            chars.forEach {
                itemContent(it, selectedChar == it)
            }
        }

        val charHeight by remember {
            derivedStateOf { sideBarSize.height.div(lastChars.size) }
        }

        selectedChar?.also { char ->
            val offsetY = charHeight.times(selectedPosition!!).plus(
                charHeight.minus(charSize.height).div(2)
            )
            Box(modifier = modifier
                .offset {
                    IntOffset(-sideBarSize.width, offsetY)
                }
                .onSizeChanged {
                    charSize = it
                }, contentAlignment = Alignment.TopEnd
            ) {
                bubbleTip(char)
            }
        }
    }
}

/**
 * 字母索引侧边栏的Item内容
 */
@Composable
private fun ColumnScope.SideBarItemContent(char: Char, selected: Boolean) {
    BasicText(
        text = char.toString(),
        style = TextStyle.Default.copy(
            fontSize = 13.sp,
            color = if (selected) Color.Black else Color.DarkGray
        ),
        modifier = Modifier
            .padding(2.dp)
            .align(Alignment.CenterHorizontally)
    )
}

/**
 * 滑动选中时的气泡提示
 */
@Composable
private fun SideBarBubbleTip(char: Char) {
    Box(contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(56.dp, 40.dp)) {
            val radius = size.minDimension.div(2f)
            val path = Path()
            path.moveTo(size.width.div(2f), 0f)
            path.lineTo(size.width, size.height.div(2f))
            path.lineTo(size.width.div(2f), size.height)
            drawPath(path = path, color = Color.LightGray)
            drawCircle(color = Color.LightGray, radius = radius)
        }
        BasicText(
            text = char.toString(),
            style = TextStyle.Default.copy(fontSize = 20.sp, color = Color.Black),
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

/**
 * 默认的字母索引数组
 */
private val defaultChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#".toCharArray()