package com.example.algorithmvisualizer.screens.list.components

import com.example.algorithmvisualizer.R

object Algorithms {

    fun getAlgorithmList(): ArrayList<Algorithm> {
        val algorithmsList = ArrayList<Algorithm>()
        val insertionSort = Algorithm(1, "Insertion Sort", R.drawable.ic_insertion_sort, "Detrius, agripeta, et lapsus.")
        val bubbleSort = Algorithm(2, "Bubble Sort", R.drawable.ic_bubble_sort, "Devirginatos tolerare, tanquam mirabilis spatii.")
        val quickSort = Algorithm(3, "Quick Sort", R.drawable.ic_quicksort, "Deuss assimilant, tanquam flavum habena.")
        val selectionSort = Algorithm(4, "Selection Sort", R.drawable.ic_selection_sort, "Nunquam experientia scutum.")
        algorithmsList.add(insertionSort)
        algorithmsList.add(bubbleSort)
        algorithmsList.add(quickSort)
        algorithmsList.add(selectionSort)
        return algorithmsList
    }


}