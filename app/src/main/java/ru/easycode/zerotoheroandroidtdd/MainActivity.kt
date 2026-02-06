package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private val titleTextView: TextView by lazy { findViewById(R.id.titleTextView) }
    private val hideButton: Button by lazy { findViewById(R.id.hideButton) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hideButton.setOnClickListener {
            titleTextView.isVisible = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(TITLE_KEY, titleTextView.isVisible)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle
    ) {
        super.onRestoreInstanceState(savedInstanceState)
        titleTextView.isVisible = savedInstanceState.getBoolean(TITLE_KEY)
    }

    companion object {
        const val TITLE_KEY = "TITLE_KEY"
    }
}
