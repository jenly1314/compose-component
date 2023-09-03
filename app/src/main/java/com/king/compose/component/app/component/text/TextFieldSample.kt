package com.king.compose.component.app.component.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.king.compose.component.text.TextField

/**
 * TextField 示例
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
@Composable
fun TextFieldSample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        var value1 by remember { mutableStateOf("") }
        TextField(value = value1,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onValueChange = {
                value1 = it
            }) {
            Column {
                Box(modifier = Modifier.padding(vertical = 8.dp)) {
                    if (value1.isEmpty()) {
                        Text(text = "默认无限制输入", color = Color.LightGray)
                    }
                    it()
                }
                Divider()
            }
        }

        var value2 by remember { mutableStateOf("") }
        TextField(value = value2,
            regex = "^\\d*",
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onValueChange = {
                value2 = it
            }) {
            Column {
                Box(modifier = Modifier.padding(vertical = 8.dp)) {
                    if (value2.isEmpty()) {
                        Text(text = "限制只能输入数字", color = Color.LightGray)
                    }
                    it()
                }
                Divider()
            }
        }

        var value3 by remember { mutableStateOf("") }
        TextField(value = value3,
            regex = "^[A-Za-z\\d]*",
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Ascii),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onValueChange = {
                value3 = it
            }) {
            Column {
                Box(modifier = Modifier.padding(vertical = 8.dp)) {
                    if (value3.isEmpty()) {
                        Text(text = "限制只能输入数字和字母", color = Color.LightGray)
                    }
                    it()
                }
                Divider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TextFieldSamplePreview() {
    TextFieldSample()
}