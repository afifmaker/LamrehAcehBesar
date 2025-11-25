package com.example.lamrehacehbesar.ui.fitur.home

import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lamrehacehbesar.R

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Klik Menu "Sejarah"
        view.findViewById<CardView>(R.id.menuSejarah).setOnClickListener {
            val bundle = Bundle().apply { putString("kategori", "Sejarah") }
            findNavController().navigate(R.id.action_home_to_wisata, bundle)
        }

        // Klik Menu "Kebencanaan"
        view.findViewById<CardView>(R.id.menuKebencanaan).setOnClickListener {
            val bundle = Bundle().apply { putString("kategori", "Kebencanaan") }
            findNavController().navigate(R.id.action_home_to_wisata, bundle)
        }

        // Klik Menu "Wisata"
        view.findViewById<CardView>(R.id.menuWisata).setOnClickListener {
            val bundle = Bundle().apply { putString("kategori", "Wisata") }
            findNavController().navigate(R.id.action_home_to_wisata, bundle)
        }

        // Klik Menu "Ekowisata"
        view.findViewById<CardView>(R.id.menuEkowisata).setOnClickListener {
            val bundle = Bundle().apply { putString("kategori", "Ekowisata") }
            findNavController().navigate(R.id.action_home_to_wisata, bundle)
        }

        // Klik Menu "Geopark"
        view.findViewById<CardView>(R.id.menuGeopark).setOnClickListener {
            val bundle = Bundle().apply { putString("kategori", "Geopark") }
            findNavController().navigate(R.id.action_home_to_wisata, bundle)
        }
    }
}