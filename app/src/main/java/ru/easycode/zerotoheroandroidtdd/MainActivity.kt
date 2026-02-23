package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val countTextView: TextView by lazy { findViewById(R.id.countTextView) }
    private val incrementButton: Button by lazy { findViewById(R.id.incrementButton) }

    private var count: Count = Count.Base(step = 2, max = 10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        incrementButton.setOnClickListener {
            countTextView.text = count.increment(countTextView.text.toString()).text
        }
    }
}
