package com.example.explorelamreh.ui.fitur.navigation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.explorelamreh.R

class NavigationFragment : Fragment(R.layout.fragment_navigation) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tombol Akhiri Navigasi
        view.findViewById<View>(R.id.btnEndNav).setOnClickListener {
            Toast.makeText(context, "Navigasi Selesai", Toast.LENGTH_SHORT).show()

            // Kembali ke Home (Reset ke awal)
            findNavController().popBackStack(R.id.homeFragment, false)
        }
    }
}