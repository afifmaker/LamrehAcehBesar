package com.example.explorelamreh.dashboard.admin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.explorelamreh.databinding.ActivityAdminProfileBinding

class AdminProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol Kembali
        binding.btnBackProfile.setOnClickListener {
            finish()
        }

        // Tombol Edit Profile
        binding.btnEditProfile.setOnClickListener {
            Toast.makeText(this, "Fitur Edit Profile segera hadir!", Toast.LENGTH_SHORT).show()
        }
    }
}