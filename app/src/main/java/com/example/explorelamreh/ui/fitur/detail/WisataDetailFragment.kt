package com.example.explorelamreh.ui.fitur.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.explorelamreh.R

class WisataDetailFragment : Fragment(R.layout.fragment_wisata_detail) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tombol Navigasi di halaman detail
        view.findViewById<View>(R.id.btnStartNavigasi).setOnClickListener {
            findNavController().navigate(R.id.action_detail_to_map)
        }
    }
}