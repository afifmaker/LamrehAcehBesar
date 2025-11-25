package com.example.lamrehacehbesar.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.lamrehacehbesar.R
import com.example.lamrehacehbesar.ui.auth.LoginActivity
import com.example.lamrehacehbesar.ui.auth.RegisterActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        findViewById<Button>(R.id.btnSignIn).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        findViewById<Button>(R.id.btnSignUp).setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}