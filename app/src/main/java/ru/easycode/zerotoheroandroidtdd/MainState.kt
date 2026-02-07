package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable


internal interface MainState : Serializable {

    fun apply(rootLayout: LinearLayout, titleTextView: TextView, removeButton: Button)

    class Initial : MainState {
        override fun apply(rootLayout: LinearLayout, titleTextView: TextView, removeButton: Button) = Unit
    }

    class RemoveTextViewState : MainState {
        override fun apply(
            rootLayout: LinearLayout,
            titleTextView: TextView,
            removeButton: Button
        ) {
            rootLayout.removeView(titleTextView)
            removeButton.isEnabled = false
        }
    }
}
