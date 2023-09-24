package com.example.algorithmvisualizer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.algorithmvisualizer.algorithms.BubbleSort
import com.example.algorithmvisualizer.algorithms.InsertionSort
import com.example.algorithmvisualizer.algorithms.QuickSort
import com.example.algorithmvisualizer.algorithms.SelectionSort
import com.example.algorithmvisualizer.screens.list.ListScreen
import com.example.algorithmvisualizer.screens.splash.SplashScreen
import com.example.algorithmvisualizer.screens.visualization.AlgorithmViewModel
import com.example.algorithmvisualizer.screens.visualization.VisualizationScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.name
    ) {
        composable(Screens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(Screens.AlgorithmsListScreen.name) {
            ListScreen(navController = navController)
        }
        composable(
            Screens.AlgorithmVisualizationScreen.name + "/{algorithmId}", arguments = listOf(
                navArgument("algorithmId") {
                    type = NavType.IntType
                }
            )
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getInt("algorithmId").let {
                VisualizationScreen(
                    navController = navController,
                    algorithmId = it!!,
                    algorithmViewModel = AlgorithmViewModel(
                        insertionSort = InsertionSort(),
                        bubbleSort = BubbleSort(),
                        quickSort = QuickSort(),
                        selectionSort = SelectionSort()
                    )
                )
            }
        }
    }
}