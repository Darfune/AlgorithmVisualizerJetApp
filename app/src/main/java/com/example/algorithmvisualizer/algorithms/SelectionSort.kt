package com.example.algorithmvisualizer.algorithms

class SelectionSort {

    suspend fun sort(
        arr: Array<Int>,
        onChange: (Array<Int>) -> Unit
    ) {
        val n = arr.size
        for (i in 0 until n - 1) {
            var minIndex = i
            for (j in i + 1 until n) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j
                }
            }
            val temp = arr[minIndex]
            arr[minIndex] = arr[i]
            arr[i] = temp
            onChange(arr)
        }
    }
}