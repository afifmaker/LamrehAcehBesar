package com.example.explorelamreh.ui.fitur.wisata

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.explorelamreh.R
import com.example.explorelamreh.data.model.Wisata
import com.example.explorelamreh.databinding.FragmentWisataBinding

class WisataFragment : Fragment(R.layout.fragment_wisata) {

    private lateinit var binding: FragmentWisataBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentWisataBinding.bind(view)

        val kategori = arguments?.getString("kategori") ?: "Wisata"
        binding.tvHeaderTitle.text = kategori

        binding.btnBack.setOnClickListener {
            val success = findNavController().navigateUp()
            if (!success) {
                findNavController().popBackStack()
            }
        }

        binding.btnMenuNavigasi.setOnClickListener {
            openMap(5.608, 95.500, true)
        }

        binding.btnMenuPeta.setOnClickListener {
            openMap(5.602, 95.495, false)
        }

        binding.btnMenuFasilitas.setOnClickListener {
            Toast.makeText(context, "Info Fasilitas...", Toast.LENGTH_SHORT).show()
        }

        binding.btnMenuAkses.setOnClickListener {
            Toast.makeText(context, "Info Akses...", Toast.LENGTH_SHORT).show()
        }

        binding.cardBukitLamreh.setOnClickListener {
            goToDetail("1", "Bukit Lamreh", "Lamreh, 4 Km", "Bukit indah dengan pemandangan laut.")
        }

        binding.cardPasirPutih.setOnClickListener {
            goToDetail("2", "Pasir Putih Lhok Me", "Lhok Me, Aceh Besar", "Pantai pasir putih eksotis.")
        }

        binding.btnProfileHeader.setOnClickListener {
            Toast.makeText(context, "Profil User", Toast.LENGTH_SHORT).show()
        }

        binding.cardSearch.setOnClickListener {
            Toast.makeText(context, "Pencarian...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openMap(lat: Double, lng: Double, isNavigation: Boolean) {
        try {
            val bundle = Bundle().apply {
                putDouble("lat", lat)
                putDouble("lng", lng)
                putBoolean("is_nav", isNavigation)
            }
            findNavController().navigate(R.id.action_wisata_to_map, bundle)
        } catch (_: Exception) {
            Toast.makeText(context, "Peta belum tersedia", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToDetail(id: String, nama: String, lokasi: String, deskripsi: String) {
        val data = Wisata(id, nama, lokasi, deskripsi, "Wisata")
        val bundle = Bundle().apply { putParcelable("WISATA_DATA", data) }

        try {
            findNavController().navigate(R.id.action_wisata_to_detail, bundle)
        } catch (_: Exception) {
            Toast.makeText(context, "Gagal membuka detail", Toast.LENGTH_SHORT).show()
        }
    }
}