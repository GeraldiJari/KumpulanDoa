// DoaListActivity.kt
package com.example.kumpulandoa

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class DoaListActivity : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var doaReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doa_list)

        // Inisialisasi Firebase dengan URL manual
        database = FirebaseDatabase.getInstance("https://pmobile-4fdf7-default-rtdb.asia-southeast1.firebasedatabase.app/")
        doaReference = database.reference.child("data")

        loadDoaFromFirebase()
    }

    private fun loadDoaFromFirebase() {
        val doaList = mutableListOf<Doa>()
        val doaListView: ListView = findViewById(R.id.doaListView)

        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (snapshot in dataSnapshot.children) {
                    val doa = snapshot.getValue(Doa::class.java)
                    doa?.let { doaList.add(it) }
                }

                displayDoaList(doaList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle onCancelled
            }
        }

        doaReference.addValueEventListener(valueEventListener)
    }

    private fun displayDoaList(doaList: List<Doa>) {
        val doaListView: ListView = findViewById(R.id.doaListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, doaList.map { it.title })
        doaListView.adapter = adapter

        doaListView.setOnItemClickListener { _, _, position, _ ->
            val selectedDoa = doaList[position]
            navigateToDetailActivity(selectedDoa)
        }
    }

    private fun navigateToDetailActivity(doa: Doa) {
        val intent = Intent(this@DoaListActivity, DoaDetailActivity::class.java)
        intent.putExtra("doa", doa)
        startActivity(intent)
    }
}
