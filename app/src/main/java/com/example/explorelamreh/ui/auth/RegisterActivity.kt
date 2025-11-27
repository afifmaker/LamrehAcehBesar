package com.example.explorelamreh.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
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

        // 1. Inisialisasi UI
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPass = findViewById<EditText>(R.id.etConfirmPass)
        val etRole = findViewById<EditText>(R.id.etRole)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnBack = findViewById<ImageView>(R.id.btnBackRegister)
        val tvLogin = findViewById<TextView>(R.id.tvGoToLogin)

        // 2. Aksi Tombol Register
        btnRegister.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPass = etConfirmPass.text.toString().trim()
            val role = etRole.text.toString().trim().lowercase()

            // --- VALIDASI ---

            // Cek jika kosong
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || role.isEmpty()) {
                Toast.makeText(this@RegisterActivity, "Semua data wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Cek Format Email
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Format email salah (contoh: user@mail.com)"
                etEmail.requestFocus()
                return@setOnClickListener
            }

            // Cek Password Match
            if (password != confirmPass) {
                etConfirmPass.error = "Password tidak sama!"
                etConfirmPass.requestFocus()
                return@setOnClickListener
            }

            // Cek Role (Harus admin/user)
            if (role != "admin" && role != "user") {
                etRole.error = "Role hanya boleh 'admin' atau 'user'"
                etRole.requestFocus()
                return@setOnClickListener
            }

            // --- SIMPAN DATA (SharedPreferences) ---
            val sharedPref = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()

            editor.putString("saved_username", username)
            editor.putString("saved_email", email)
            editor.putString("saved_password", password)
            editor.putString("saved_role", role)

            editor.apply() // Simpan data di background

            Toast.makeText(this@RegisterActivity, "Registrasi Berhasil! Silakan Login.", Toast.LENGTH_LONG).show()

            // Pindah ke Login
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            // Hapus history register agar user tidak bisa back ke sini
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        // 3. Tombol Kembali
        btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 4. Link ke Login
        tvLogin.setOnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}