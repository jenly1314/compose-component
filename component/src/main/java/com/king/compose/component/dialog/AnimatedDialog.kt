package com.king.compose.component.dialog

import androidx.annotation.FloatRange
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider

/**
 * 动画对话框：主要是在[Dialog]的基础之上增加了可见性过渡动画，并解决[Dialog]的宽度显示问题；
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 *
 * @param visible 是否显示对话框
 * @param onDismissRequest 关闭对话框；当用户试图关闭对话框时，会执行此函数
 * @param enter 对话框显示时的入场动画
 * @param exit 对话框消失时的退场动画
 * @param dismissOnBackPress 是否可以系统返回键来关闭对话框；默认为：true
 * @param dimAmount 对话框背景蒙层；范围从：1.0（不透明）到 0.0（完全透明）；默认为：0.6
 * @param contentAlignment 对话框内容的对齐方式；默认为：[Alignment.TopStart]
 * @param content 对话框的内容
 */
@Composable
fun AnimatedDialog(
    visible: Boolean,
    onDismissRequest: () -> Unit,
    enter: EnterTransition = fadeIn(),
    exit: ExitTransition = fadeOut(),
    dismissOnBackPress: Boolean = true,
    @FloatRange(from = 0.0, to = 1.0)
    dimAmount: Float = 0.6f,
    contentAlignment: Alignment = Alignment.TopStart,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    val visibleState = remember {
        MutableTransitionState(false)
    }.apply {
        this.targetState = visible
    }

    if (visible || !visibleState.isIdle) {
        Dialog(
            onDismissRequest = onDismissRequest,
            properties = DialogProperties(dismissOnBackPress = dismissOnBackPress)
        ) {
            val window = (LocalView.current.parent as? DialogWindowProvider)?.window
            val width = LocalContext.current.resources.displayMetrics.widthPixels
            LaunchedEffect(dimAmount) {
                window?.also {
                    it.attributes.dimAmount = dimAmount
                    /*
                     * 此处通过设置Dialog的宽高，让Dialog宽度可以与屏幕宽度一致；
                     * 之所以不使用：DialogProperties.usePlatformDefaultWidth=false来实现，是因为
                     * 当DialogProperties.usePlatformDefaultWidth=false时，在某些机型上显示的Dialog的宽度会超出屏幕。
                     */
                    it.setLayout(width, it.attributes.height)
                }
            }
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = contentAlignment) {
                AnimatedVisibility(
                    visibleState = visibleState,
                    enter = enter,
                    exit = exit,
                ) {
                    content()
                }
            }
        }
    }
}