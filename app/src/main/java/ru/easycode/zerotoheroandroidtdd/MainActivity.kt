package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val decrementButton: Button by lazy { findViewById(R.id.decrementButton) }
    private val countTextView: TextView by lazy { findViewById(R.id.countTextView) }
    private val incrementButton: Button by lazy { findViewById(R.id.incrementButton) }

    private var count: Count = Count.Base(min = 0, step = 2, max = 5)

    private var state: UiState = count.initial("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decrementButton.setOnClickListener {
            changeStateTo(count.decrement(countTextView.text.toString()))
        }

        incrementButton.setOnClickListener {
            changeStateTo(count.increment(countTextView.text.toString()))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(STATE_KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val restoredState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(STATE_KEY, UiState::class.java) as UiState
        } else {
            savedInstanceState.getSerializable(STATE_KEY) as UiState
        }

        changeStateTo(restoredState)
    }

    private fun changeStateTo(state: UiState) {
        this.state = state
        state.apply(decrementButton, countTextView, incrementButton)
    }

    companion object {
        const val STATE_KEY = "STATE_KEY"
    }
}
