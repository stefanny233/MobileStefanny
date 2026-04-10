package com.example.paniapps.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.paniapps.R
import com.example.paniapps.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Set onClickListener
        binding.btnkirim.setOnClickListener {
            val isiInput = binding.inputNoTujuan.text.toString()

            if (isiInput.isEmpty()) {
                Toast.makeText(this, "Nomor tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Berhasil terkirim ke nomor: $isiInput", Toast.LENGTH_SHORT).show()
            }
            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent)
        }
    }
}