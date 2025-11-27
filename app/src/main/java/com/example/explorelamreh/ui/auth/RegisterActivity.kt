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

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // 1. Inisialisasi Komponen UI
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPass = findViewById<EditText>(R.id.etConfirmPass)
        val etRole = findViewById<EditText>(R.id.etRole) // Input: "admin" atau "user"
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnBack = findViewById<ImageView>(R.id.btnBackRegister)
        val tvLogin = findViewById<TextView>(R.id.tvGoToLogin)

        // 2. Aksi Tombol Register
        btnRegister.setOnClickListener {
            val username = etUsername.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val confirmPass = etConfirmPass.text.toString()
            val role = etRole.text.toString().lowercase().trim() // Ubah ke huruf kecil biar gampang dicek

            // Validasi Input
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || role.isEmpty()) {
                Toast.makeText(this, "Semua data wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPass) {
                Toast.makeText(this, "Password konfirmasi tidak sama", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validasi Role (Hanya boleh admin atau user)
            if (role != "admin" && role != "user") {
                Toast.makeText(this, "Role harus diisi 'admin' atau 'user'", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 3. SIMPAN DATA KE MEMORI (SharedPreferences)
            val sharedPref = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()

            // Simpan data
            editor.putString("saved_email", email)
            editor.putString("saved_password", password)
            editor.putString("saved_role", role) // INI KUNCINYA (Menyimpan status admin/user)
            editor.putString("saved_username", username)
            editor.apply()

            Toast.makeText(this, "Registrasi Berhasil! Silakan Login.", Toast.LENGTH_LONG).show()

            // Pindah ke Halaman Login
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        // Tombol Navigasi Lain
        btnBack.setOnClickListener { finish() }
        tvLogin.setOnClickListener { finish() }
    }
}