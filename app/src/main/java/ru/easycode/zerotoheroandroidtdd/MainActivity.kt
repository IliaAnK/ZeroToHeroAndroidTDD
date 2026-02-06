package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val titleTextView: TextView by lazy { findViewById(R.id.titleTextView) }
    private val changeButton: Button by lazy { findViewById(R.id.changeButton) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeButton.setOnClickListener {
            titleTextView.text = getString(R.string.i_am_an_android_developer)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TITLE_KEY, titleTextView.text.toString())
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle
    ) {
        super.onRestoreInstanceState(savedInstanceState)
        titleTextView.text = savedInstanceState.getString(TITLE_KEY)
    }

    companion object {
        const val TITLE_KEY = "title"
    }
}
