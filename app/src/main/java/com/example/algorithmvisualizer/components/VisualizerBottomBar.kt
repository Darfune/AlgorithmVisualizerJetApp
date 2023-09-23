package com.example.algorithmvisualizer.components


import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.algorithmvisualizer.R

@Composable
fun VisualizerBottomBar(
    modifier: Modifier = Modifier,
    startPauseClick: () -> Unit,
    speedUpClick: () -> Unit,
    speedDownClick: () -> Unit,
    nextStepClick: () -> Unit,
    previousStepClick: () -> Unit,
    isPlaying: Boolean = false
) {
    BottomAppBar(modifier = modifier.background(MaterialTheme.colorScheme.surface)) {

    }
}

@Composable
fun ButtonRow(
    startPauseClick: () -> Unit,
    speedUpClick: () -> Unit,
    speedDownClick: () -> Unit,
    nextStepClick: () -> Unit,
    previousStepClick: () -> Unit,
    isPlaying: Boolean = false
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        IconButton(onClick = previousStepClick) {
            Icon(
                painter = painterResource(id = R.drawable.ic_prev_step_24),
                contentDescription = "Previous Step",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        IconButton(onClick = nextStepClick) {
            Icon(
                painter = painterResource(id = R.drawable.ic_next_step_24),
                contentDescription = "Increase Speed",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        IconButton(onClick = startPauseClick) {
            Icon(
                painter = painterResource(id = if (!isPlaying) R.drawable.ic_play else R.drawable.ic_pause_24),
                contentDescription = "Start or Pause",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
        IconButton(onClick = speedDownClick) {
            Icon(
                painter = painterResource(id = R.drawable.ic_change_speed_24),
                contentDescription = "Increase Speed",
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.rotate(180f)
            )
        }
        IconButton(onClick = speedUpClick) {
            Icon(
                painter = painterResource(id = R.drawable.ic_change_speed_24),
                contentDescription = "Increase Speed",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
