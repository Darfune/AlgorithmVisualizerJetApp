package com.example.algorithmvisualizer.algorithms

class QuickSort {
    suspend fun partition(
        arr: Array<Int>,
        low: Int,
        high: Int,
        onChange: () -> Unit
    ): Int {
        val pivot = arr[high]
        var i = (low - 1)
        for (j in low until high) {
            if (arr[j] < pivot) {
                i++
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
        val temp = arr[i + 1]
        arr[i + 1] = arr[high]
        arr[high] = temp
        return (i + 1)
    }

    suspend fun quickSort(arr: Array<Int>, low: Int, high: Int, onChange: (Array<Int>) -> Unit) {
        if (low < high) {
            val pi = partition(arr, low, high, onChange = {onChange(arr)})
            quickSort(arr, low, pi - 1, onChange = {onChange(arr)})
            quickSort(arr, pi + 1, high, onChange = {onChange(arr)})
        }
    }

    suspend fun sort(
        arr: Array<Int>,
        onChange: (Array<Int>) -> Unit
    ) {
        val n = arr.size
        quickSort(arr, 0, n - 1, onChange = {onChange(arr)})
    }

}