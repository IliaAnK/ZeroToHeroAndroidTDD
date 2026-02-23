package ru.easycode.zerotoheroandroidtdd

interface UiState {
    val text: String


    data class Base(override val text: String) : UiState
    data class Max(override val text: String) : UiState
}
