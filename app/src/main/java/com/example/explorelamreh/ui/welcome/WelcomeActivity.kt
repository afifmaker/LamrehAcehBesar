package com.example.explorelamreh.ui.welcome

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.explorelamreh.databinding.ActivityWelcomeBinding
import com.example.explorelamreh.ui.auth.LoginActivity
import com.example.explorelamreh.ui.auth.RegisterActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.btnSignIn.addClickEffect()
        binding.btnSignUp.addClickEffect()

        binding.btnSignIn.setOnClickListener {
            delayAndGo {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }

        binding.btnSignUp.setOnClickListener {
            delayAndGo {
                startActivity(Intent(this, RegisterActivity::class.java))
            }
        }
    }

    private fun delayAndGo(action: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed({
            action()
        }, 150)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun View.addClickEffect() {
        this.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.animate().scaleX(0.95f).scaleY(0.95f).alpha(0.9f).setDuration(100).start()
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    v.animate().scaleX(1f).scaleY(1f).alpha(1f).setDuration(100).start()
                }
            }
            false
        }
    }
}