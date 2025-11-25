package com.example.lamrehacehbesar.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lamrehacehbesar.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            // Simulasi sukses register, kembali ke login
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        findViewById<TextView>(R.id.tvGoToLogin).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}