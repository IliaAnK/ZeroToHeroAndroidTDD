package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.contains

class MainActivity : AppCompatActivity() {
    private val rootLayout: LinearLayout by lazy { findViewById(R.id.rootLayout) }
    private val titleTextView: TextView by lazy { findViewById(R.id.titleTextView) }
    private val removeButton: Button by lazy { findViewById(R.id.removeButton) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        removeButton.setOnClickListener {
            rootLayout.removeView(titleTextView)
            removeButton.isEnabled = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(IS_TEXT_VIEW_REMOVED_KEY, !rootLayout.contains(titleTextView))
        outState.putBoolean(IS_REMOVE_BUTTON_ENABLED_KEY, removeButton.isEnabled)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle
    ) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.getBoolean(IS_TEXT_VIEW_REMOVED_KEY)) {
            rootLayout.removeView(titleTextView)
        }
        removeButton.isEnabled = savedInstanceState.getBoolean(IS_REMOVE_BUTTON_ENABLED_KEY)
    }

    companion object {
        const val IS_TEXT_VIEW_REMOVED_KEY = "IS_TEXT_VIEW_REMOVED_KEY"
        const val IS_REMOVE_BUTTON_ENABLED_KEY = "IS_REMOVE_BUTTON_ENABLED_KEY"
    }
}
