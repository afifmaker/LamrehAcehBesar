package com.example.explorelamreh.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.explorelamreh.data.model.Wisata
import com.example.explorelamreh.databinding.ItemAdminListBinding

class AdminAdapter(
    private val listData: MutableList<Wisata>,
    private val onEdit: (Wisata, Int) -> Unit,
    private val onDelete: (Wisata, Int) -> Unit,
    private val onItemClick: (Wisata) -> Unit // TAMBAHAN: Untuk klik seluruh item
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

        // AKSI BARU: Klik pada seluruh baris item (untuk Detail)
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }

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