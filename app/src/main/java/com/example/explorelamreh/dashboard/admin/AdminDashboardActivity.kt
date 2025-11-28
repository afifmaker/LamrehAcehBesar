@file:Suppress("SpellCheckingInspection")

package com.example.explorelamreh.dashboard.admin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.explorelamreh.dashboard.admin.kelola.AdminEkowisataActivity
import com.example.explorelamreh.dashboard.admin.kelola.AdminGeoparkActivity
import com.example.explorelamreh.dashboard.admin.kelola.AdminKebencanaanActivity
import com.example.explorelamreh.dashboard.admin.kelola.AdminSejarahActivity
import com.example.explorelamreh.dashboard.admin.kelola.AdminWisataActivity
import com.example.explorelamreh.databinding.ActivityAdminDashboardBinding
import com.example.explorelamreh.ui.auth.LoginActivity

class AdminDashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnHomeAdmin.setOnClickListener {
            Toast.makeText(this, "Anda sudah di Dashboard Admin", Toast.LENGTH_SHORT).show()
        }

        binding.btnUserAdmin.setOnClickListener {
            Toast.makeText(this, "Fitur Profil Admin belum tersedia", Toast.LENGTH_SHORT).show()
        }

        binding.btnLogoutAdmin.setOnClickListener {
            showLogoutConfirmation()
        }

        binding.btnAdminGeopark.setOnClickListener {
            startActivity(Intent(this, AdminGeoparkActivity::class.java))
        }

        binding.btnAdminEkowisata.setOnClickListener {
            startActivity(Intent(this, AdminEkowisataActivity::class.java))
        }

        binding.btnAdminBencana.setOnClickListener {
            startActivity(Intent(this, AdminKebencanaanActivity::class.java))
        }

        binding.btnAdminWisata.setOnClickListener {
            startActivity(Intent(this, AdminWisataActivity::class.java))
        }

        binding.btnAdminSejarah.setOnClickListener {
            startActivity(Intent(this, AdminSejarahActivity::class.java))
        }

        binding.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun showLogoutConfirmation() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Konfirmasi Logout")
        builder.setMessage("Apakah Anda yakin ingin keluar dari aplikasi?")

        builder.setPositiveButton("Ya") { _, _ ->
            Toast.makeText(this, "Logout Berhasil", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        builder.setNegativeButton("Batal") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }
}