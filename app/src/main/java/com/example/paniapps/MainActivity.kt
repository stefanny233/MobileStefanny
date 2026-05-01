package com.example.paniapps

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.paniapps.databinding.ActivityMainBinding
import com.example.paniapps.pertemuan_4.FourthActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->

                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()

                    startActivity(Intent(this, AuthActivity::class.java))
                    finish()
                }

                .setNegativeButton("Tidak", null)
                .show()
        }
    }
}