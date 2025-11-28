package com.example.explorelamreh.ui.fitur

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.explorelamreh.data.model.Wisata
import com.example.explorelamreh.databinding.ActivityWisataDetailBinding

class WisataDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWisataDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWisataDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Intent
        val wisataData = intent.getParcelableExtra<Wisata>("WISATA_DATA")

        if (wisataData != null) {
            displayData(wisataData)
            setupListeners(wisataData)
        } else {
            Toast.makeText(this, "Data wisata tidak ditemukan.", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun displayData(data: Wisata) {
        // Tampilkan data ke layout
        binding.tvNamaWisata.text = data.nama
        binding.tvLokasiWisata.text = data.lokasi
        binding.tvDeskripsiWisata.text = data.deskripsi
        // Note: Image dan Header perlu library (misalnya Glide/Picasso) untuk dimuat
    }

    private fun setupListeners(data: Wisata) {
        binding.btnBack.setOnClickListener {
            finish()
        }

        // Tombol AR View (Fungsi AR akan dibuat di Activity lain)
        binding.btnARView.setOnClickListener {
            // Kita akan kirim data lokasi (Lat/Lng) ke Activity AR
            Toast.makeText(this, "Membuka AR View untuk lokasi: ${data.nama}", Toast.LENGTH_SHORT).show()

            // Nanti di sini kita ganti dengan Intent ke Activity AR Anda:
            // val intent = Intent(this, ARNavigationActivity::class.java).apply {
            //     putExtra("LAT", data.lat)
            //     putExtra("LNG", data.lng)
            // }
            // startActivity(intent)
        }
    }
}