package com.example.algorithmvisualizer.screens.list

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.algorithmvisualizer.navigation.Screens
import com.example.algorithmvisualizer.screens.list.components.AlgorithmItem
import com.example.algorithmvisualizer.screens.list.components.Algorithms


@Composable
fun ListScreen(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 4.dp, horizontal = 4.dp)
        ) {
            items(items = Algorithms.getAlgorithmList()) { algo ->
                AlgorithmItem(
                    name = algo.getName(),
                    image = algo.getImage(),
                    description = algo.getDescription()
                ) {
                    navController.navigate(
                        Screens.AlgorithmVisualizationScreen.name + "/${algo.getId()}"
                    )
                }
            }
        }
    }
}