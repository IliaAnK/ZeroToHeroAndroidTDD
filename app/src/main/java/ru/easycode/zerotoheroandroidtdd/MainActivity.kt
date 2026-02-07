package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val rootLayout: LinearLayout by lazy { findViewById(R.id.rootLayout) }
    private val titleTextView: TextView by lazy { findViewById(R.id.titleTextView) }
    private val removeButton: Button by lazy { findViewById(R.id.removeButton) }

    private var state: MainState = MainState.Initial()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        removeButton.setOnClickListener {
            changeStateTo(MainState.RemoveTextViewState())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(STATE_KEY, state)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle
    ) {
        super.onRestoreInstanceState(savedInstanceState)
        val restoredState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(STATE_KEY, MainState::class.java) as MainState
        } else {
            savedInstanceState.getSerializable(STATE_KEY) as MainState
        }

        changeStateTo(restoredState)
    }

    private fun changeStateTo(state: MainState) {
        this.state = state
        state.apply(rootLayout, titleTextView, removeButton)
    }

    companion object {
        const val STATE_KEY = "STATE_KEY"
    }
}
