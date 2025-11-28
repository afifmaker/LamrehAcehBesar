package com.example.explorelamreh.ui.fitur.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.explorelamreh.R

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fungsi bantuan untuk navigasi ke WisataFragment dengan membawa data kategori
        fun navigateToWisata(kategori: String) {
            val bundle = Bundle().apply {
                putString("kategori", kategori)
            }
            findNavController().navigate(R.id.action_home_to_wisata, bundle)
        }

        // Menu Geopark
        view.findViewById<View>(R.id.menuGeopark)?.setOnClickListener {
            navigateToWisata("Geopark")
        }

        // Menu Sejarah
        view.findViewById<View>(R.id.menuSejarah)?.setOnClickListener {
            navigateToWisata("Sejarah")
        }

        // Menu Ekowisata
        view.findViewById<View>(R.id.menuEkowisata)?.setOnClickListener {
            navigateToWisata("Ekowisata")
        }

        // Menu Kebencanaan
        view.findViewById<View>(R.id.menuKebencanaan)?.setOnClickListener {
            navigateToWisata("Kebencanaan")
        }

        // Menu Wisata (Umum)
        view.findViewById<View>(R.id.menuWisata)?.setOnClickListener {
            navigateToWisata("Wisata")
        }

        // Card Jelajah (Bukit Lamreh) -> Langsung ke detail atau kategori Wisata
        view.findViewById<View>(R.id.cardJelajah)?.setOnClickListener {
            navigateToWisata("Wisata Populer")
        }
    }
}