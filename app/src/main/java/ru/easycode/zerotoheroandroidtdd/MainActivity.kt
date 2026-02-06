package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

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
}
