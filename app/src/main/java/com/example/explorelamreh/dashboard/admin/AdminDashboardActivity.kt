package com.example.lamrehacehbesar.dashboard.admin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lamrehacehbesar.R
import com.example.lamrehacehbesar.ui.auth.LoginActivity

class AdminDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)

        findViewById<View>(R.id.btnLogoutAdmin).setOnClickListener {
            Toast.makeText(this, "Logout Berhasil", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        findViewById<View>(R.id.btnAdminGeopark).setOnClickListener {
            Toast.makeText(this, "Menu Geopark", Toast.LENGTH_SHORT).show()
        }

        findViewById<View>(R.id.btnAdminEkowisata).setOnClickListener {
            Toast.makeText(this, "Menu Ekowisata", Toast.LENGTH_SHORT).show()
        }

        findViewById<View>(R.id.btnAdminBencana).setOnClickListener {
            Toast.makeText(this, "Menu Kebencanaan", Toast.LENGTH_SHORT).show()
        }

        findViewById<View>(R.id.btnAdminWisata).setOnClickListener {
            Toast.makeText(this, "Menu Wisata", Toast.LENGTH_SHORT).show()
        }

        findViewById<View>(R.id.btnAdminSejarah).setOnClickListener {
            Toast.makeText(this, "Menu Sejarah", Toast.LENGTH_SHORT).show()
        }
    }
}