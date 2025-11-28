package com.example.explorelamreh.ui.fitur.wisata

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.explorelamreh.R

class WisataFragment : Fragment(R.layout.fragment_wisata) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val kategori = arguments?.getString("kategori") ?: "Wisata"

        val tvHeaderTitle = view.findViewById<TextView>(R.id.tvHeaderTitle)
        tvHeaderTitle.text = kategori

        view.findViewById<View>(R.id.btnBack).setOnClickListener {
            findNavController().popBackStack()
        }

        view.findViewById<View>(R.id.menuNavigasi).setOnClickListener {
            val bundle = Bundle().apply {
                putDouble("lat", 5.608)
                putDouble("lng", 95.500)
            }
            findNavController().navigate(R.id.action_wisata_to_map, bundle)
        }

        view.findViewById<View>(R.id.cardBukitLamreh).setOnClickListener {
            findNavController().navigate(R.id.action_wisata_to_detail)
        }
    }
}