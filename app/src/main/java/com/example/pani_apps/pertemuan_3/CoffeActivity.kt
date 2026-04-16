package com.example.pani_apps.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pani_apps.databinding.ActivityCoffeBinding

class CoffeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoffeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCoffeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                // Peringatan jika kosong menggunakan Toast
                Toast.makeText(this,
                    "Isi username dan password dulu ya!", Toast.LENGTH_SHORT)
                    .show()

                // Atau pakai Error di EditText agar lebih keren
                if (username.isEmpty()) binding.etUsername.error = "Username wajib diisi"
                if (password.isEmpty()) binding.etPassword.error = "Password wajib diisi"

            } else {
                // Jika sudah diisi, pindah halaman
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
                finish() // Menutup halaman login agar tidak bisa back ke login lagi
            }
        }
    }
}