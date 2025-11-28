@file:Suppress("SpellCheckingInspection")

package com.example.explorelamreh.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.explorelamreh.dashboard.admin.AdminDashboardActivity
import com.example.explorelamreh.dashboard.user.UserDashboardActivity
import com.example.explorelamreh.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnLogin.setOnClickListener {
            val inputEmail = binding.etEmailLogin.text.toString().trim()
            val inputPassword = binding.etPasswordLogin.text.toString().trim()

            if (inputEmail.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(this, "Mohon isi Email dan Password!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (inputEmail == "admin@explore.com" && inputPassword == "admin123") {
                Toast.makeText(this, "Selamat Datang Admin!", Toast.LENGTH_SHORT).show()
                goToDashboard(isAdmin = true)
                return@setOnClickListener
            }

            val sharedPref = getSharedPreferences("UserDatabase", MODE_PRIVATE)
            val savedEmail = sharedPref.getString("saved_email", null)
            val savedPassword = sharedPref.getString("saved_password", null)

            if (inputEmail == savedEmail && inputPassword == savedPassword) {
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                goToDashboard(isAdmin = false)
            } else {
                Toast.makeText(this, "Email atau Password Salah!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvGoToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnBackLogin.setOnClickListener {
            finish()
        }

        val viewRoot = binding.root
        viewRoot.findViewById<android.view.View>(com.example.explorelamreh.R.id.btnGoogle)?.setOnClickListener { openUrl("https://accounts.google.com/") }
        viewRoot.findViewById<android.view.View>(com.example.explorelamreh.R.id.btnFacebook)?.setOnClickListener { openUrl("https://facebook.com/") }
        viewRoot.findViewById<android.view.View>(com.example.explorelamreh.R.id.btnApple)?.setOnClickListener { openUrl("https://appleid.apple.com/") }
    }

    private fun goToDashboard(isAdmin: Boolean) {
        val intent = if (isAdmin) {
            Intent(this, AdminDashboardActivity::class.java)
        } else {
            Intent(this, UserDashboardActivity::class.java)
        }
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
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