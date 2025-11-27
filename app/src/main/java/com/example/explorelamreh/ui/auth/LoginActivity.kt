package com.example.explorelamreh.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.explorelamreh.R
import com.example.explorelamreh.dashboard.admin.AdminDashboardActivity
import com.example.explorelamreh.dashboard.user.UserDashboardActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmailLogin)
        val etPassword = findViewById<EditText>(R.id.etPasswordLogin)
        val etRole = findViewById<EditText>(R.id.etRoleLogin)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvGoToRegister)
        val btnBack = findViewById<ImageView>(R.id.btnBackLogin)

        btnLogin.setOnClickListener {
            val inputEmail = etEmail.text.toString().trim()
            val inputPassword = etPassword.text.toString().trim()
            val inputRole = etRole.text.toString().trim().lowercase()

            if (inputEmail.isEmpty() || inputPassword.isEmpty() || inputRole.isEmpty()) {
                Toast.makeText(this@LoginActivity, "Mohon isi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Ambil data dari SharedPreferences
            val sharedPref = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE)
            val savedEmail = sharedPref.getString("saved_email", null)
            val savedPassword = sharedPref.getString("saved_password", null)
            val savedRole = sharedPref.getString("saved_role", null)

            // Logika Login Sederhana
            if (inputEmail == savedEmail && inputPassword == savedPassword) {
                if (inputRole == savedRole) {
                    Toast.makeText(this@LoginActivity, "Login Berhasil!", Toast.LENGTH_SHORT).show()

                    // Pindah halaman sesuai Role
                    if (savedRole == "admin") {
                        val intent = Intent(this@LoginActivity, AdminDashboardActivity::class.java)
                        // Bersihkan stack agar tidak bisa back ke login
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                        finish()
                    } else if (savedRole == "user") {
                        val intent = Intent(this@LoginActivity, UserDashboardActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                        finish()
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Role salah! Akun ini terdaftar sebagai '$savedRole'", Toast.LENGTH_LONG).show()
                }
            } else {
                // Jika email/password salah atau belum ada akun
                if (savedEmail == null) {
                    Toast.makeText(this@LoginActivity, "Akun belum terdaftar!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@LoginActivity, "Email atau Password Salah", Toast.LENGTH_SHORT).show()
                }
            }
        }

        tvRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }

        btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}