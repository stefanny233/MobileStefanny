package com.example.pani_apps.pertemuan_2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pani_apps.databinding.ActivityMainBinding
import com.example.pani_apps.databinding.ActivitySecond2Binding
import com.example.pani_apps.pertemuan_3.CoffeActivity
import com.example.pani_apps.pertemuan_3.WelcomeActivity
import com.example.pani_apps.pertemuan_4.CustomActivity2
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // tombol 1 → kalkulator
        binding.btnRumus.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
        // tombol 2 → coffee menu
        binding.btnCoffee.setOnClickListener {
            startActivity(Intent(this, CoffeActivity::class.java))
        }
        // tombol 3 → custom 2
        binding.btnCustom2.setOnClickListener {
            startActivity(Intent(this, CustomActivity2::class.java))
        }

        // tombol 4 → logout
        binding.btnLogout.setOnClickListener {
            showLogoutDialog()
        }
    }

    private fun showLogoutDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Konfirmasi Logout")
            .setMessage("Apakah ingin logout?")
            .setPositiveButton("Ya") { dialog, _ ->
                dialog.dismiss()
                startActivity(Intent(this, CoffeActivity::class.java))
                finish()
            }
            .setNegativeButton("Tidak") { dialog, _ ->
                dialog.dismiss()
                Snackbar.make(binding.root, "Logout dibatalkan",
                    Snackbar.LENGTH_SHORT).show()
            }
            .show()
    }
}