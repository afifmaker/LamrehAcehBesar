@file:Suppress("SpellCheckingInspection")

package com.example.explorelamreh.ui.auth

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.explorelamreh.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnBackForgot.setOnClickListener {
            finish()
        }

        binding.btnSendReset.setOnClickListener {
            val email = binding.etEmailForgot.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(this, "Mohon isi email Anda!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmailForgot.error = "Format email salah"
                return@setOnClickListener
            }

            Toast.makeText(this, "Mengirim link reset...", Toast.LENGTH_SHORT).show()

            Handler(Looper.getMainLooper()).postDelayed({
                Toast.makeText(this, "Link reset password telah dikirim ke email Anda!", Toast.LENGTH_LONG).show()
                finish()
            }, 1500)
        }
    }
}