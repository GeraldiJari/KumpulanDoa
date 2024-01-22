// DoaDetailActivity.kt
package com.example.kumpulandoa

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DoaDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_doa)

        val intent = intent
        if (intent.hasExtra("doa")) {
            val doa: Doa = intent.getSerializableExtra("doa") as Doa
            displayDoaDetails(doa)
        }
    }

    private fun displayDoaDetails(doa: Doa) {
        val textViewTitle: TextView = findViewById(R.id.textViewTitle)
        val textViewArabic: TextView = findViewById(R.id.textViewArabic)
        val textViewLatin: TextView = findViewById(R.id.textViewLatin)
        val textViewTranslation: TextView = findViewById(R.id.textViewTranslation)

        textViewTitle.text = doa.title
        textViewArabic.text = doa.arabic
        textViewLatin.text = doa.latin
        textViewTranslation.text = doa.translation
    }
}
