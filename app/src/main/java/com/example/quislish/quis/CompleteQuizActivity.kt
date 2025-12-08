package com.example.quislish.quis

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quislish.R
import com.example.quislish.main.HomeActivity
import androidx.activity.OnBackPressedCallback


class CompleteQuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_complete_quiz)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {

                    val intent = Intent(this@CompleteQuizActivity, HomeActivity::class.java)
                    intent.putExtra("fragment", "home")

                    // tidak membuat activity baru
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)

                    startActivity(intent)
                    finish()
                }
            }
        )

        val bottomNext = findViewById<Button>(R.id.bottomNext)

        bottomNext.setOnClickListener {
            val intent = Intent(this, StrikeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}