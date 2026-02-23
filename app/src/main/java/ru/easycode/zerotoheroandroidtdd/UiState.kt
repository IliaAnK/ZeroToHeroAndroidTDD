package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {
    val text: String

    fun apply(decrementButton: Button, textView: TextView, incrementButton: Button)

    data class Min(override val text: String) : UiState {
        override fun apply(decrementButton: Button, textView: TextView, incrementButton: Button) {
            decrementButton.isEnabled = false
            textView.text = text
            incrementButton.isEnabled = true
        }
    }

    data class Base(override val text: String) : UiState {
        override fun apply(decrementButton: Button, textView: TextView, incrementButton: Button) {
            decrementButton.isEnabled = true
            textView.text = text
            incrementButton.isEnabled = true
        }
    }

    data class Max(override val text: String) : UiState {
        override fun apply(decrementButton: Button, textView: TextView, incrementButton: Button) {
            decrementButton.isEnabled = true
            textView.text = text
            incrementButton.isEnabled = false
        }
    }
}
