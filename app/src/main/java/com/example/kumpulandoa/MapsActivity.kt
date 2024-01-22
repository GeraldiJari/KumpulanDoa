package com.example.kumpulandoa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kumpulandoa.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val Yogyakarta = LatLng(-7.8332349,110.3809325)
        mMap.addMarker(
            MarkerOptions().position(Yogyakarta)
            .title("Lokasi Kampus 4 UAD"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Yogyakarta))

        mMap.animateCamera(CameraUpdateFactory.zoomTo(10.0f))
    }
}