package com.example.algorithmvisualizer

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.algorithmvisualizer.algorithms.BubbleSort
import com.example.algorithmvisualizer.algorithms.InsertionSort
import com.example.algorithmvisualizer.algorithms.QuickSort
import com.example.algorithmvisualizer.algorithms.SelectionSort
import kotlinx.coroutines.launch
import kotlin.random.Random

class AlgorithmViewModel(
    private val insertionSort: InsertionSort,
    private val bubbleSort: BubbleSort,
    private val quickSort: QuickSort,
    private val selectionSort: SelectionSort
) : ViewModel() {

    // Create a random number generator
    val numbers = Random.Default

    // Create a mutable array of 30 random numbers from 1 to 50
    val intArrayOf = mutableStateOf(Array<Int>(30) { numbers.nextInt(50) + 1 })
    val isPlaying = mutableStateOf(false)
    val onSortingFinished = mutableStateOf(false)
    private var delay = 100L
    private var onSortingArray = mutableListOf<List<Int>>()

    private fun insertionSort(intArrayOf: MutableState<Array<Int>>) {
        viewModelScope.launch {
            insertionSort.sort(intArrayOf.value.clone()) { modifiedArray ->
                onSortingArray.add(modifiedArray.toMutableList())
            }
        }
    }

    private fun bubbleSort(intArrayOf: MutableState<Array<Int>>) {
        viewModelScope.launch {
            bubbleSort.sort(intArrayOf.value.clone()) { modifiedArray ->
                onSortingArray.add(modifiedArray.toMutableList())
            }
        }
    }

    private fun quickSort(intArrayOf: MutableState<Array<Int>>) {
        viewModelScope.launch {
            quickSort.sort(intArrayOf.value.clone()) { modifiedArray ->
                onSortingArray.add(modifiedArray.toMutableList())
            }
        }
    }

    private fun selectionSort(intArrayOf: MutableState<Array<Int>>) {
        viewModelScope.launch {
            selectionSort.sort(intArrayOf.value.clone()) { modifiedArray ->
                onSortingArray.add(modifiedArray.toMutableList())
            }
        }
    }

}