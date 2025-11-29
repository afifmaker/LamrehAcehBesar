package com.example.explorelamreh.dashboard.admin.kelola

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.explorelamreh.data.model.Wisata
import com.example.explorelamreh.databinding.ActivityAdminListFeatureBinding
import com.example.explorelamreh.databinding.DialogFormWisataBinding
import com.example.explorelamreh.ui.adapter.AdminAdapter
import com.example.explorelamreh.ui.fitur.WisataDetailActivity

class AdminSejarahActivity : AppCompatActivity() {

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
        binding.tvTitlePage.text = "Kelola Data Sejarah"
        // Data Dummy
        dataList.add(Wisata("1", "Benteng Indra Patra", "Lamreh", "Peninggalan kerajaan", "Sejarah"))
    }

    private fun setupRecyclerView() {
        adapter = AdminAdapter(dataList,
            onEdit = { item, pos -> showDialogForm(item, pos) },
            onDelete = { item, pos -> showDeleteConfirmation(item, pos) },
            onItemClick = { item -> goToDetail(item) } // Tambahkan onItemClick untuk detail
        )
        binding.rvData.layoutManager = LinearLayoutManager(this)
        binding.rvData.adapter = adapter
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener { finish() }
        binding.fabAdd.setOnClickListener { showDialogForm(null, -1) }
    }

    private fun goToDetail(item: Wisata) {
        val intent = Intent(this, WisataDetailActivity::class.java).apply {
            putExtra("WISATA_DATA", item)
        }
        startActivity(intent)
    }

    // --- LOGIC CRUD: CREATE & UPDATE (PERBAIKAN ERROR findViewById) ---
    private fun showDialogForm(existingItem: Wisata?, position: Int) {
        // Menggunakan View Binding untuk Dialog
        val dialogBinding = DialogFormWisataBinding.inflate(LayoutInflater.from(this))

        // Akses views via Binding
        val etNama = dialogBinding.etNama
        val etLokasi = dialogBinding.etLokasi
        val etDeskripsi = dialogBinding.etDeskripsi
        val tvTitle = dialogBinding.tvDialogTitle

        if (existingItem != null) {
            tvTitle.text = "Edit Data"
            etNama.setText(existingItem.nama)
            etLokasi.setText(existingItem.lokasi)
            etDeskripsi.setText(existingItem.deskripsi)
        } else {
            tvTitle.text = "Tambah Data Baru"
        }

        AlertDialog.Builder(this)
            .setView(dialogBinding.root) // Gunakan root dari binding dialog
            .setCancelable(false)
            .setPositiveButton("Simpan") { _, _ ->
                val nama = etNama.text.toString()
                val lokasi = etLokasi.text.toString()
                val deskripsi = etDeskripsi.text.toString()

                if (nama.isNotEmpty() && lokasi.isNotEmpty()) {
                    if (existingItem == null) {
                        val newItem = Wisata(System.currentTimeMillis().toString(), nama, lokasi, deskripsi, "Sejarah")
                        dataList.add(newItem)
                        adapter.notifyItemInserted(dataList.size - 1)
                        Toast.makeText(this, "Data Berhasil Ditambah", Toast.LENGTH_SHORT).show()
                    } else {
                        existingItem.nama = nama
                        existingItem.lokasi = lokasi
                        existingItem.deskripsi = deskripsi
                        adapter.notifyItemChanged(position)
                        Toast.makeText(this, "Data Berhasil Diubah", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Nama dan Lokasi wajib diisi", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun showDeleteConfirmation(item: Wisata, position: Int) {
        AlertDialog.Builder(this)
            .setTitle("Hapus Data?")
            .setMessage("Hapus '${item.nama}'?")
            .setPositiveButton("Hapus") { _, _ ->
                dataList.removeAt(position)
                adapter.notifyItemRemoved(position)
                adapter.notifyItemRangeChanged(position, dataList.size)
                Toast.makeText(this, "Data Terhapus", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Batal", null)
            .show()
    }
}