package com.example.kumpulandoa

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.kumpulandoa.databinding.ActivityMainBinding
import com.example.kumpulandoa.databinding.ActivityMapsBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //List Doa
        val btnShowDoaList = findViewById<RelativeLayout>(R.id.btnShowDoaList)
        btnShowDoaList.setOnClickListener {
            val intent = Intent(this@MainActivity, DoaListActivity::class.java)
            startActivity(intent)
        }

        //Google Maps
        val btnShowMap = findViewById<RelativeLayout>(R.id.btnShowMaps)
        btnShowMap.setOnClickListener {
            val intent = Intent(this@MainActivity, MapsActivity::class.java)
            startActivity(intent)
        }

//        binding.fabGoToMaps.setOnClickListener {
//            val intent =Intent(this@MainActivity, MapsActivity::class.java)
//            startActivity(intent)
//        }
    }
}
