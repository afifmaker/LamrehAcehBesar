@file:Suppress("SpellCheckingInspection")

package com.example.explorelamreh.ui.fitur.map

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.explorelamreh.R
import com.example.explorelamreh.databinding.FragmentMapBinding
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(R.layout.fragment_map), OnMapReadyCallback {

    private lateinit var binding: FragmentMapBinding
    private var googleMap: GoogleMap? = null

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                enableMyLocation()
                moveToCurrentLocation()
            } else {
                Toast.makeText(context, "Izin lokasi diperlukan untuk fitur ini", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMapBinding.bind(view)

        // PERBAIKAN: Gunakan 'map_container' (bukan 'map') sesuai XML terbaru
        val mapFragment = childFragmentManager.findFragmentById(R.id.map_container) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        setupButtons()
    }

    private fun setupButtons() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.cardSearch.setOnClickListener {
            Toast.makeText(context, "Fitur Pencarian Peta...", Toast.LENGTH_SHORT).show()
        }

        binding.btnZoomIn.setOnClickListener {
            googleMap?.animateCamera(CameraUpdateFactory.zoomIn())
        }

        binding.btnZoomOut.setOnClickListener {
            googleMap?.animateCamera(CameraUpdateFactory.zoomOut())
        }

        binding.btnMyLocation.setOnClickListener {
            checkPermissionAndMove()
        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        val lat = arguments?.getDouble("lat") ?: 5.608
        val lng = arguments?.getDouble("lng") ?: 95.500
        val isNavigationMode = arguments?.getBoolean("is_nav") ?: false

        val lokasiTujuan = LatLng(lat, lng)
        val zoomLevel = if (isNavigationMode) 18f else 13f

        map.addMarker(MarkerOptions().position(lokasiTujuan).title("Lokasi Wisata"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(lokasiTujuan, zoomLevel))

        if (isNavigationMode) {
            Toast.makeText(context, "Mode Navigasi Aktif", Toast.LENGTH_SHORT).show()
        }

        enableMyLocation()
    }

    private fun checkPermissionAndMove() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            moveToCurrentLocation()
        } else {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private fun enableMyLocation() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            googleMap?.isMyLocationEnabled = true
            googleMap?.uiSettings?.isMyLocationButtonEnabled = false
        }
    }

    private fun moveToCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                if (location != null) {
                    val currentLatLng = LatLng(location.latitude, location.longitude)
                    googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 17f))
                } else {
                    Toast.makeText(context, "Lokasi tidak ditemukan, pastikan GPS aktif", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}