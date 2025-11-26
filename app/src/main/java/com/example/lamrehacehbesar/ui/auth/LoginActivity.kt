package com.example.lamrehacehbesar.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lamrehacehbesar.R
import com.example.lamrehacehbesar.dashboard.admin.AdminDashboardActivity
import com.example.lamrehacehbesar.dashboard.user.UserDashboardActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmailLogin)
        val etPassword = findViewById<EditText>(R.id.etPasswordLogin)
        val etRole = findViewById<EditText>(R.id.etRoleLogin)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnBack = findViewById<ImageView>(R.id.btnBackLogin)
        val tvRegister = findViewById<TextView>(R.id.tvGoToRegister)

        btnLogin.setOnClickListener {
            val inputEmail = etEmail.text.toString()
            val inputPassword = etPassword.text.toString()
            val inputRole = etRole.text.toString().lowercase().trim()

            if (inputEmail.isEmpty() || inputPassword.isEmpty() || inputRole.isEmpty()) {
                Toast.makeText(this, "Isi email, password, dan role!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val sharedPref = getSharedPreferences("UserDatabase", Context.MODE_PRIVATE)
            val savedEmail = sharedPref.getString("saved_email", null)
            val savedPassword = sharedPref.getString("saved_password", null)
            val savedRole = sharedPref.getString("saved_role", null)

            if (inputEmail == savedEmail && inputPassword == savedPassword) {
                if (inputRole == savedRole) {
                    Toast.makeText(this, "Login Berhasil sebagai $savedRole", Toast.LENGTH_SHORT).show()

                    if (savedRole == "admin") {
                        startActivity(Intent(this, AdminDashboardActivity::class.java))
                    } else {
                        startActivity(Intent(this, UserDashboardActivity::class.java))
                    }
                    finishAffinity()
                } else {
                    Toast.makeText(this, "Role salah! Akun ini terdaftar sebagai $savedRole", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Email atau Password Salah!", Toast.LENGTH_SHORT).show()
            }
        }

        btnBack.setOnClickListener { finish() }
        tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}