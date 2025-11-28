@file:Suppress("SpellCheckingInspection", "StringFormatInTimber", "StringFormatMatches", "StringShouldBeStoredInResources")

package com.example.explorelamreh.dashboard.admin.kelola

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.explorelamreh.R
import com.example.explorelamreh.data.model.Wisata
import com.example.explorelamreh.databinding.ActivityAdminListFeatureBinding
import com.example.explorelamreh.ui.adapter.AdminAdapter
import com.example.explorelamreh.ui.fitur.WisataDetailActivity // FIX: Tambahkan import Activity Detail

class AdminGeoparkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminListFeatureBinding
    private lateinit var adapter: AdminAdapter

    private val dataList = mutableListOf<Wisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminListFeatureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
        setupRecyclerView()
        setupListeners()
    }

    private fun setupUI() {
        binding.tvTitlePage.text = "Kelola Data Geopark"

        // FIX: Data Wisata sekarang punya 5 parameter
        dataList.add(Wisata("1", "Bukit Lamreh", "Lamreh, Aceh Besar", "Pemandangan laut indah", "Geopark"))
        dataList.add(Wisata("2", "Tebing Ujung Kelindu", "Lamreh, Aceh Besar", "Tebing curam eksotis", "Geopark"))
    }

    private fun setupRecyclerView() {
        adapter = AdminAdapter(dataList,
            onEdit = { item, pos -> showDialogForm(item, pos) },
            onDelete = { item, pos -> showDeleteConfirmation(item, pos) },
            onItemClick = { item -> goToDetail(item) }
        )
        binding.rvData.layoutManager = LinearLayoutManager(this)
        binding.rvData.adapter = adapter
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener { finish() }
        binding.fabAdd.setOnClickListener { showDialogForm(null, -1) }
    }

    // FIX UTAMA: Kirim data ke Activity Detail
    private fun goToDetail(item: Wisata) {
        val intent = Intent(this, WisataDetailActivity::class.java).apply {
            // FIX: putExtra harus dipanggil pada object Intent
            putExtra("WISATA_DATA", item)
        }
        startActivity(intent)
    }

    private fun showDialogForm(existingItem: Wisata?, position: Int) {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_form_wisata, null)

        // ... (Logika Dialog tetap sama, tidak diubah) ...

        // FIX: Hapus etRole di sini jika kamu menggunakan kode lama yang saya berikan
        // Karena kita sudah membuang input Role, kita asumsikan kamu sudah menghapus findViewById Role

        // ... (Logika Dialog tetap sama) ...
    }

    private fun showDeleteConfirmation(item: Wisata, position: Int) {
        // ... (Logika Hapus tetap sama) ...
    }
}