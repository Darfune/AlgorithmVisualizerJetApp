package com.example.algorithmvisualizer.screens.visualization.components


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
    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
        val itemWidth = remember {
            maxWidth / array.size - 1.dp
        }

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            array.forEach {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = it.toString(),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 8.sp
                    )
                    Box(
                        modifier = Modifier
                            .height(screensMaxHeight * it / 50 )
                            .width(itemWidth)
                            .padding(horizontal = 2.dp)
                            .background(MaterialTheme.colorScheme.secondary)
                            .background(color = MaterialTheme.colorScheme.secondary)
                    ) {

                    }
                }

            }
        }
    }
}