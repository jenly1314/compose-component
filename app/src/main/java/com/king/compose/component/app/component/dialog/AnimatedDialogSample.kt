package com.king.compose.component.app.component.dialog

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.king.compose.component.dialog.AnimatedDialog

/**
 * AnimatedDialogSample 示例
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
@Composable
fun AnimatedDialogSample() {

    var visible by remember { mutableStateOf(false) }

    var enter by remember { mutableStateOf(fadeIn()) }
    var exit by remember { mutableStateOf(fadeOut()) }
    var contentAlignment by remember { mutableStateOf(Alignment.Center) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = {
            contentAlignment = Alignment.Center
            enter = scaleIn()
            exit = scaleOut()
            visible = true
        }, modifier = Modifier.width(200.dp)) {
            Text(text = "Scale in")
        }

        Button(onClick = {
            contentAlignment = Alignment.CenterStart
            enter = slideInHorizontally(initialOffsetX = { -it })
            exit = slideOutHorizontally(targetOffsetX = { -it })
            visible = true
        }, modifier = Modifier.width(200.dp)) {
            Text(text = "Left in")
        }

        Button(onClick = {
            contentAlignment = Alignment.TopCenter
            enter = slideInVertically(initialOffsetY = { -it })
            exit = slideOutVertically(targetOffsetY = { -it })
            visible = true
        }, modifier = Modifier.width(200.dp)) {
            Text(text = "Top in")
        }

        Button(onClick = {
            contentAlignment = Alignment.CenterEnd
            enter = slideInHorizontally(initialOffsetX = { it.times(2) })
            exit = slideOutHorizontally(targetOffsetX = { it.times(2) })
            visible = true
        }, modifier = Modifier.width(200.dp)) {
            Text(text = "Right in")
        }

        Button(onClick = {
            contentAlignment = Alignment.BottomCenter
            enter = slideInVertically(initialOffsetY = { it.times(2) })
            exit = slideOutVertically(targetOffsetY = { it.times(2) })
            visible = true
        }, modifier = Modifier.width(200.dp)) {
            Text(text = "Bottom in")
        }

    }

    AnimatedDialog(
        visible = visible,
        onDismissRequest = { visible = false },
        enter = enter,
        exit = exit,
        contentAlignment = contentAlignment,
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {

            Text(text = "对话框示例；点击关闭", modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .clickable {
                    visible = false
                }
                .padding(10.dp))
        }
    }
}