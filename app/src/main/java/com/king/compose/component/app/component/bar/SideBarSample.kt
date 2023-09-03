package com.king.compose.component.app.component.bar

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.king.compose.component.bar.SideBar
import kotlinx.coroutines.launch
import java.util.Random

/**
 * SideBar 示例
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SideBarSample() {
    val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#".toCharArray()
    val list by remember {
        val tempList = mutableListOf<Pair<String, String>>()
        val random = Random()
        chars.forEach { char ->
            val count = random.nextInt(10) + 1
            // 随机构造一些数据
            repeat(count) {
                tempList.add(Pair(char.toString(), "$char$it"))
            }
        }
        mutableStateOf<List<Pair<String, String>>>(tempList)
    }

    val positionMap by remember {
        val tempMap = mutableMapOf<String, Int>()
        list.forEachIndexed { index, pair ->
            val key = pair.first
            if (!tempMap.containsKey(key)) {
                tempMap[key] = index
            }
        }
        mutableStateOf<Map<String, Int>>(tempMap)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        val lazyListState = rememberLazyListState()
        LazyColumn(modifier = Modifier.fillMaxSize(), state = lazyListState) {
            list.forEachIndexed { index, pair ->
                if (positionMap[pair.first] == index) {
                    stickyHeader {
                        Text(
                            text = pair.first,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.LightGray)
                                .padding(horizontal = 16.dp, vertical = 4.dp)
                        )
                    }
                }
                item {
                    Text(text = pair.second, modifier = Modifier.padding(16.dp))
                }
            }

        }

        val scope = rememberCoroutineScope()
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd) {
            SideBar(
                modifier = Modifier.padding(horizontal = 8.dp),
                onSelectedChange = { char ->
                    positionMap[char.toString()]?.also { position ->
                        scope.launch {
                            lazyListState.scrollToItem(
                                index = position + chars.indexOfFirst { it == char }
                            )
                        }
                    }
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SideBarSamplePreview() {
    SideBarSample()
}