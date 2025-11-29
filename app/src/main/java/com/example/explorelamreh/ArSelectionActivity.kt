package com.example.explorelamreh

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ArSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar_selection)

        // 1. Tombol Back
        findViewById<View>(R.id.btnBack).setOnClickListener {
            finish() // Kembali ke dashboard
        }

        // 2. Siapkan Data 17 Wisata
        // (ID ini yang nanti dikirim ke Unity)
        val listWisata = listOf(
            WisataArModel(1, "Benteng Inong Balee"),
            WisataArModel(2, "Benteng Kuta Lubok"),
            WisataArModel(3, "Bukit Lamreh"),
            WisataArModel(4, "Bukit Soeharto"),
            WisataArModel(5, "Gunung Amad Ramanyang"),
            WisataArModel(6, "Kawasan Kerajaan Lamuri"),
            WisataArModel(7, "Kulam Putroe Ijo"),
            WisataArModel(8, "Makam Benteng Lubok"),
            WisataArModel(9, "Makam Laksamana Keumalahayati"),
            WisataArModel(10, "Pasir Putih"),
            WisataArModel(11, "Snorkeling Lubok"),
            WisataArModel(12, "Spot Foto Mercusuar"),
            WisataArModel(13, "Spot Mancing Lubok"),
            WisataArModel(14, "Spot Mancing Puteh"),
            WisataArModel(15, "Tebing Gruk-Gruk"),
            WisataArModel(16, "Tebing Puteh"),
            WisataArModel(17, "Wisata Geologi Tebing")
        )

        // 3. Setup RecyclerView
        val rv = findViewById<RecyclerView>(R.id.rvWisataAr)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = WisataArAdapter(listWisata) { selectedItem ->
            // === AKSI SAAT ITEM DIKLIK ===
            bukaUnityAr(selectedItem.id)
        }
    }

    private fun bukaUnityAr(idWisata: Int) {
        Toast.makeText(this, "Membuka AR untuk ID: $idWisata...", Toast.LENGTH_SHORT).show()

        // NANTI: Di sini kita akan memanggil Activity Unity
        // val intent = Intent(this, com.unity3d.player.UnityPlayerActivity::class.java)
        // intent.putExtra("selectedID", idWisata)
        // startActivity(intent)
    }
}

// === BAGIAN ADAPTER & MODEL (Bisa ditaruh satu file biar praktis) ===

data class WisataArModel(val id: Int, val nama: String)

class WisataArAdapter(
    private val dataList: List<WisataArModel>,
    private val onItemClick: (WisataArModel) -> Unit
) : RecyclerView.Adapter<WisataArAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNomor: TextView = view.findViewById(R.id.tvNomor)
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
        holder.tvNomor.text = item.id.toString()
        holder.tvNama.text = item.nama

        holder.card.setOnClickListener { onItemClick(item) }
    }

    override fun getItemCount() = dataList.size
}