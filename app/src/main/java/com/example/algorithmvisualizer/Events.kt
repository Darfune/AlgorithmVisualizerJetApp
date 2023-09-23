package com.example.algorithmvisualizer

sealed class Events{
    object DecreaseSpeed: Events()
    object IncreaseSpeed: Events()
    object PlayPauseAlgorithm: Events()
    object PauseAlgorithm: Events()
    object NextStep: Events()
    object PreviousStep: Events()
}
