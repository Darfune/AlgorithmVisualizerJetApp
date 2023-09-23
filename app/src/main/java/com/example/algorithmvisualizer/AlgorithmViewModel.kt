package com.example.algorithmvisualizer

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.algorithmvisualizer.algorithms.BubbleSort
import com.example.algorithmvisualizer.algorithms.InsertionSort
import com.example.algorithmvisualizer.algorithms.QuickSort
import com.example.algorithmvisualizer.algorithms.SelectionSort
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.sign
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
    var isPaused = mutableStateOf(false)
    var next = 1
    var previous = 0
    var sortingState = 0
    val onSortingFinished = mutableStateOf(false)
    private var delay = 100L
    private var onSortingArray = mutableListOf<List<Int>>()


    fun onEvent(event: Events) {
        when (event) {
            is Events.PlayPauseAlgorithm -> playPauseAlgorithm()
            is Events.NextStep -> nextStep()
            is Events.PreviousStep -> previousStep()
            is Events.IncreaseSpeed -> increaseSpeed()
            is Events.DecreaseSpeed -> decreaseSpeed()
            else -> {}
        }
    }

    //Play and Pause functions
    private fun playPauseAlgorithm() {
        if (isPlaying.value) pause()
        else play()
        isPlaying.value = !isPlaying.value
    }

    private fun play() = viewModelScope.launch {

        for (i in sortingState until onSortingArray.size) {
            if (!isPaused.value) {
                delay(delay)
                intArrayOf.value = onSortingArray[i].toTypedArray()
            } else {
                sortingState = 1
                next = i + 1
                previous = i
                return@launch
            }
        }
        onSortingFinished.value = true
    }

    private fun pause() {
        isPaused.value = true
    }

    private fun nextStep() {
        if (next < onSortingArray.size){
            intArrayOf.value = onSortingArray[next].toTypedArray()
            next++
            previous++
        }
    }

    private fun previousStep() {
        if (previous >= 0){
            intArrayOf.value = onSortingArray[previous].toTypedArray()
            next--
            previous--
        }
    }

    private fun increaseSpeed() {
        if (delay > 50L)
            delay -= 50
    }

    private fun decreaseSpeed() {
        delay += 50
    }


    //Algorithms Functions

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