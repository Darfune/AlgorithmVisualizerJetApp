package com.example.algorithmvisualizer.screens.visualization

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.algorithmvisualizer.Events
import com.example.algorithmvisualizer.components.VisualizationSection
import com.example.algorithmvisualizer.components.VisualizerBottomBar

@Composable
fun VisualizationScreen(
    algorithmViewModel: AlgorithmViewModel
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Bottom
        ) {

            VisualizationSection(
                array = algorithmViewModel.intArrayOf.value,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp),
                screensMaxHeight = screenHeight - 75.dp
            )

            val isPlaying = algorithmViewModel.isPlaying.value
            val isFinished = algorithmViewModel.onSortingFinished.value

            VisualizerBottomBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp),
                startPauseClick = { algorithmViewModel.onEvent(Events.PlayPauseAlgorithm) },

                speedUpClick = { algorithmViewModel.onEvent(Events.IncreaseSpeed) },
                speedDownClick = { algorithmViewModel.onEvent(Events.DecreaseSpeed) },
                nextStepClick = { algorithmViewModel.onEvent(Events.NextStep) },
                previousStepClick = { algorithmViewModel.onEvent(Events.PreviousStep) },
                isPlaying = if (isFinished) !isPlaying else isPlaying,
            )
        }
    }
}