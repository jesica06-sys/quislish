package com.example.quislish

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quislish.navigasi.HomeActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Ambil ID dari XML
        val username = findViewById<EditText>(R.id.username)
        val btnNext = findViewById<Button>(R.id.button2)

        // Aksi Tombol
        btnNext.setOnClickListener {
            val name = username.text.toString().trim()

            if (name.isEmpty()) {
                Toast.makeText(this, "Username wajib diisi!", Toast.LENGTH_SHORT).show()
            } else {
                // pindah activity
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("username", name)
                startActivity(intent)
            }
        }
    }
}