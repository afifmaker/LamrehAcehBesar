package com.example.explorelamreh // <-- Pastikan sesuai package Anda

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ArSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar_selection)

        // Tombol Back
        findViewById<View>(R.id.btnBack).setOnClickListener {
            finish()
        }

        // === DATA WISATA DENGAN GAMBAR ===
        // Pastikan nama file gambar di folder drawable Anda:
        // wisata1.png, wisata2.png, dst...
        val listWisata = listOf(
            WisataArModel(1, "Benteng Inong Balee", R.drawable.wisata1),
            WisataArModel(2, "Benteng Kuta Lubok", R.drawable.wisata2),
            WisataArModel(3, "Bukit Soeharto", R.drawable.wisata3),
            WisataArModel(4, "Wisata Geologi Tebing", R.drawable.wisata4),
            WisataArModel(5, "Gunung Amad Ramanyang", R.drawable.wisata5),
            WisataArModel(6, "Kawasan Kerajaan Lamuri", R.drawable.wisata6),
            WisataArModel(7, "Kulam Putroe Ijo", R.drawable.wisata7),
            WisataArModel(8, "Bukit Lamreh", R.drawable.wisata8),
            WisataArModel(9, "Makam Benteng Lubok", R.drawable.wisata9),
            WisataArModel(10, "Makam Laksamana Keumalahayati", R.drawable.wisata10),
            WisataArModel(11, "Mercusuar", R.drawable.wisata11),
            WisataArModel(12, "Pasir Putih", R.drawable.wisata12),
            WisataArModel(13, "Snorkling Lubok", R.drawable.wisata13),
            WisataArModel(14, "Spot Mancing Pureh", R.drawable.wisata14),
            WisataArModel(15, "Spot Mancing Lubok", R.drawable.wisata15),
            WisataArModel(16, "Tebing Gruk-Gruk", R.drawable.wisata16),
            WisataArModel(17, "Tebing Pureh", R.drawable.wisata17)
        )

        val rv = findViewById<RecyclerView>(R.id.rvWisataAr)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = WisataArAdapter(listWisata) { selectedItem ->
            bukaUnityAr(selectedItem.id)
        }
    }

    private fun bukaUnityAr(idWisata: Int) {
        Toast.makeText(this, "Scan AR: Wisata No. $idWisata", Toast.LENGTH_SHORT).show()

        // --- NANTI INTEGRASI UNITY DISINI ---
    }
}

// === MODEL DATA BARU (Tambah variable gambar) ===
data class WisataArModel(
    val id: Int,
    val nama: String,
    val gambar: Int // ID Gambar dari Drawable
)

// === ADAPTER BARU ===
class WisataArAdapter(
    private val dataList: List<WisataArModel>,
    private val onItemClick: (WisataArModel) -> Unit
) : RecyclerView.Adapter<WisataArAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Kita ubah tvNomor menjadi imgWisata
        val imgWisata: ImageView = view.findViewById(R.id.imgWisata)
        val tvNama: TextView = view.findViewById(R.id.tvNamaWisata)
        val card: View = view.findViewById(R.id.cardItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wisata_ar, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        holder.tvNama.text = item.nama
        // Set Gambar ke ImageView
        holder.imgWisata.setImageResource(item.gambar)

        holder.card.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount() = dataList.size
}