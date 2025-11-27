package com.example.explorelamreh.dashboard.admin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.explorelamreh.R
import com.example.explorelamreh.ui.auth.LoginActivity

class AdminDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)

        // Tombol Logout
        findViewById<View>(R.id.btnLogoutAdmin).setOnClickListener {
            Toast.makeText(this, "Logout Berhasil", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            // Membersihkan back stack agar tidak bisa kembali ke halaman admin setelah logout
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Tombol Menu Geopark
        findViewById<View>(R.id.btnAdminGeopark).setOnClickListener {
            Toast.makeText(this, "Menu Geopark", Toast.LENGTH_SHORT).show()
        }

        // Tombol Menu Ekowisata
        findViewById<View>(R.id.btnAdminEkowisata).setOnClickListener {
            Toast.makeText(this, "Menu Ekowisata", Toast.LENGTH_SHORT).show()
        }

        // Tombol Menu Kebencanaan
        findViewById<View>(R.id.btnAdminBencana).setOnClickListener {
            Toast.makeText(this, "Menu Kebencanaan", Toast.LENGTH_SHORT).show()
        }

        // Tombol Menu Wisata
        findViewById<View>(R.id.btnAdminWisata).setOnClickListener {
            Toast.makeText(this, "Menu Wisata", Toast.LENGTH_SHORT).show()
        }

        // Tombol Menu Sejarah
        findViewById<View>(R.id.btnAdminSejarah).setOnClickListener {
            Toast.makeText(this, "Menu Sejarah", Toast.LENGTH_SHORT).show()
        }
    }
}