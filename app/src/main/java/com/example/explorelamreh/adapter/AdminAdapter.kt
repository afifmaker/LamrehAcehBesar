package com.example.explorelamreh.ui.adapter // Sesuaikan jika package adapter Anda beda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.explorelamreh.data.model.Wisata // Import model Wisata yang baru
import com.example.explorelamreh.databinding.ItemAdminListBinding

class AdminAdapter(
    private val listData: MutableList<Wisata>, // Menggunakan data class 'Wisata'
    private val onEdit: (Wisata, Int) -> Unit,
    private val onDelete: (Wisata, Int) -> Unit
) : RecyclerView.Adapter<AdminAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemAdminListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAdminListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listData[position]

        // Bind Data ke Tampilan
        holder.binding.tvNamaWisata.text = item.nama
        holder.binding.tvLokasiWisata.text = item.lokasi

        // Aksi Tombol Edit
        holder.binding.btnEdit.setOnClickListener {
            onEdit(item, position)
        }

        // Aksi Tombol Hapus
        holder.binding.btnDelete.setOnClickListener {
            onDelete(item, position)
        }
    }

    override fun getItemCount() = listData.size
}