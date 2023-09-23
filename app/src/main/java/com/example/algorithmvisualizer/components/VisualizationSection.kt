package com.example.algorithmvisualizer.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VisualizationSection(
    modifier: Modifier = Modifier,
    array: Array<Int>,
    screensMaxHeight: Dp
) {
    BoxWithConstraints(modifier = modifier) {
        val itemWidth = remember {
            maxWidth / array.size - 5.dp
        }

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            array.forEach {
                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = it.toString(),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 12.sp
                    )
                    Box(
                        modifier = Modifier
                            .height(if (it.dp > screensMaxHeight) screensMaxHeight else it.dp * 7)
                            .width(itemWidth)
                            .background(MaterialTheme.colorScheme.secondary)
                            .background(color = MaterialTheme.colorScheme.secondary)
                    ) {

                    }
                }

            }
        }
    }
}