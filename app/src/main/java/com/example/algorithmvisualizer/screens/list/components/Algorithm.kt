package com.example.algorithmvisualizer.screens.list.components

class Algorithm(
    private var id: Int,
    private var name: String,
    private var image: Int,
    private var description: String
) {
    fun getId(): Int = id
    fun getName(): String = name
    fun getImage(): Int = image
    fun getDescription(): String = description
}