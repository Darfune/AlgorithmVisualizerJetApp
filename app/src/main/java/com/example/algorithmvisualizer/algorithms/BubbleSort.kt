package com.example.algorithmvisualizer.algorithms

class BubbleSort {
    suspend fun sort(
        arr: Array<Int>,
        onChange: (Array<Int>) -> Unit
    ) {
        val n = arr.size
        for (i in 0 until n) {
            for (j in 0 until n - i - 1) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    val temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                    onChange(arr)
                }
            }
        }
    }
}