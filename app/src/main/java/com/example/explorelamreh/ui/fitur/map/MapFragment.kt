package com.example.explorelamreh.ui.fitur.map

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.explorelamreh.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(R.layout.fragment_map) {

    private val callback = OnMapReadyCallback { googleMap ->
        // Koordinat Default (Bisa diganti dengan data dari argumen)
        val lokasiTujuan = LatLng(5.608, 95.500)

        googleMap.addMarker(MarkerOptions().position(lokasiTujuan).title("Lokasi Wisata"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasiTujuan, 15f))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}