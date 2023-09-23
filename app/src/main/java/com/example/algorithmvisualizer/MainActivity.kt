package com.example.algorithmvisualizer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.algorithmvisualizer.algorithms.BubbleSort
import com.example.algorithmvisualizer.algorithms.InsertionSort
import com.example.algorithmvisualizer.algorithms.QuickSort
import com.example.algorithmvisualizer.algorithms.SelectionSort
import com.example.algorithmvisualizer.navigation.Navigation
import com.example.algorithmvisualizer.screens.visualization.AlgorithmViewModel
import com.example.algorithmvisualizer.ui.theme.AlgorithmVisualizerTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlgorithmVisualizerTheme {
                Navigation()
            }
        }
    }
}
