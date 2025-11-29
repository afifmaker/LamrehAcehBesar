package com.example.explorelamreh.ui.fitur.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.explorelamreh.R
// Pastikan baris import ini ada (jika merah, tekan Alt+Enter pada ArSelectionActivity di bawah)
import com.example.explorelamreh.ArSelectionActivity

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun navigateToWisata(kategori: String) {
            val bundle = Bundle().apply {
                putString("kategori", kategori)
            }
            findNavController().navigate(R.id.action_home_to_wisata, bundle)
        }

        view.findViewById<View>(R.id.menuGeopark)?.setOnClickListener { navigateToWisata("Geopark") }
        view.findViewById<View>(R.id.menuSejarah)?.setOnClickListener { navigateToWisata("Sejarah") }
        view.findViewById<View>(R.id.menuEkowisata)?.setOnClickListener { navigateToWisata("Ekowisata") }
        view.findViewById<View>(R.id.menuKebencanaan)?.setOnClickListener { navigateToWisata("Kebencanaan") }
        view.findViewById<View>(R.id.menuWisata)?.setOnClickListener { navigateToWisata("Wisata") }

        view.findViewById<View>(R.id.cardJelajah)?.setOnClickListener { navigateToWisata("Wisata Populer") }

        view.findViewById<View>(R.id.menuArScan)?.setOnClickListener {
            val intent = android.content.Intent(requireContext(), ArSelectionActivity::class.java)
            startActivity(intent)
        }
    }
}