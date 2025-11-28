package com.example.explorelamreh.ui.welcome

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.explorelamreh.databinding.ActivityWelcomeBinding
import com.example.explorelamreh.ui.auth.LoginActivity
import com.example.explorelamreh.ui.auth.RegisterActivity

class WelcomeActivity : AppCompatActivity() {

    // Deklarasi variabel binding
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Panggil fungsi logika tombol
        setupListeners()
    }

    private fun setupListeners() {
        // Tombol Sign In -> Ke Login
        binding.btnSignIn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        // Tombol Sign Up -> Ke Register
        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}