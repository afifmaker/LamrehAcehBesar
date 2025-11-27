package com.example.explorelamreh.ui.fitur.route

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.explorelamreh.R

// Menghubungkan dengan layout fragment_route.xml yang sudah dibuat sebelumnya
class RouteFragment : Fragment(R.layout.fragment_route) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Tombol Back (Kembali ke halaman sebelumnya)
        view.findViewById<View>(R.id.btnBackRoute).setOnClickListener {
            findNavController().popBackStack()
        }

        // 2. Tombol "Pilih Jalur Ini"
        view.findViewById<Button>(R.id.btnPilihJalur).setOnClickListener {
            // Skenario: Setelah pilih jalur, masuk ke Peta Navigasi (GPS)
            Toast.makeText(context, "Memulai Navigasi...", Toast.LENGTH_SHORT).show()

            // Arahkan ke Fragment Map (Peta)
            findNavController().navigate(R.id.action_route_to_map)
        }
    }
}