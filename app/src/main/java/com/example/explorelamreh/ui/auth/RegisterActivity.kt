package com.example.explorelamreh.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.net.toUri
import com.example.explorelamreh.R
import com.example.explorelamreh.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnRegister.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirmPass = binding.etConfirmPass.text.toString().trim()
            val role = binding.etRole.text.toString().trim().lowercase()
            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || role.isEmpty()) {
                Toast.makeText(this, "Semua data wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.error = "Format email salah"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPass) {
                binding.etConfirmPass.error = "Password tidak sama!"
                binding.etConfirmPass.requestFocus()
                return@setOnClickListener
            }

            if (role != "admin" && role != "user") {
                binding.etRole.error = "Role hanya boleh admin atau user"
                binding.etRole.requestFocus()
                return@setOnClickListener
            }

            val sharedPref = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE)

            sharedPref.edit {
                putString("saved_username", username)
                putString("saved_email", email)
                putString("saved_password", password)
                putString("saved_role", role)
            }

            Toast.makeText(this, "Registrasi Berhasil! Silakan Login.", Toast.LENGTH_LONG).show()

            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        binding.btnBackRegister.setOnClickListener {
            finish()
        }

        binding.tvGoToLogin.setOnClickListener {
            finish()
        }

        val viewRoot = binding.root
        viewRoot.findViewById<android.view.View>(R.id.btnGoogle)?.setOnClickListener { openUrl("https://accounts.google.com/") }
        viewRoot.findViewById<android.view.View>(R.id.btnFacebook)?.setOnClickListener { openUrl("https://facebook.com/") }
        viewRoot.findViewById<android.view.View>(R.id.btnApple)?.setOnClickListener { openUrl("https://appleid.apple.com/") }
    }

    private fun openUrl(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, url.toUri())
            startActivity(intent)
        } catch (_: Exception) {
            Toast.makeText(this, "Browser tidak ditemukan", Toast.LENGTH_SHORT).show()
        }
    }
}