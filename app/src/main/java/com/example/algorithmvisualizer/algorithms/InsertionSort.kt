package com.example.algorithmvisualizer.algorithms

class InsertionSort {

    suspend fun sort (
        arr: Array<Int>,
        onChange: (Array<Int>) -> Unit,
    ){
        for (i in 1 until arr.size) {
            val key = arr[i]
            var j = i - 1
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]
                onChange(arr)
                j--
            }
            arr[j + 1] = key
        }
    }

}