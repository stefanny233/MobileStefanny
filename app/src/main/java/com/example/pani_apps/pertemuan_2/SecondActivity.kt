package com.example.pani_apps.pertemuan_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pani_apps.R

class SecondActivity : AppCompatActivity() {

    private lateinit var inputAlas: EditText
    private lateinit var inputTinggiSegitiga: EditText
    private lateinit var btnHitungSegitiga: Button
    private lateinit var hasilSegitiga: TextView

    private lateinit var inputPanjang: EditText
    private lateinit var inputLebar: EditText
    private lateinit var inputTinggiBalok: EditText
    private lateinit var btnHitungBalok: Button
    private lateinit var hasilBalok: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)

        // Inisialisasi komponen
        inputAlas = findViewById(R.id.inputAlas)
        inputTinggiSegitiga = findViewById(R.id.inputTinggiSegitiga)
        btnHitungSegitiga = findViewById(R.id.btnHitungSegitiga)
        hasilSegitiga = findViewById(R.id.hasilSegitiga)

        inputPanjang = findViewById(R.id.inputPanjang)
        inputLebar = findViewById(R.id.inputLebar)
        inputTinggiBalok = findViewById(R.id.inputTinggiBalok)
        btnHitungBalok = findViewById(R.id.btnHitungBalok)
        hasilBalok = findViewById(R.id.hasilBalok)

        // Hitung Luas Segitiga
        btnHitungSegitiga.setOnClickListener {
            hitungLuasSegitiga()
        }

        // Hitung Volume Balok
        btnHitungBalok.setOnClickListener {
            hitungVolumeBalok()
        }
    }

    private fun hitungLuasSegitiga() {
        val alasStr = inputAlas.text.toString()
        val tinggiStr = inputTinggiSegitiga.text.toString()

        if (alasStr.isEmpty() || tinggiStr.isEmpty()) {
            Toast.makeText(this, "Masukkan alas dan tinggi!", Toast.LENGTH_SHORT).show()
            return
        }

        val alas = alasStr.toDoubleOrNull()
        val tinggi = tinggiStr.toDoubleOrNull()

        if (alas == null || tinggi == null) {
            Toast.makeText(this, "Masukkan angka yang valid!", Toast.LENGTH_SHORT).show()
            return
        }

        val luas = 0.5 * alas * tinggi
        hasilSegitiga.text = "Luas Segitiga: $luas cm²"
    }

    private fun hitungVolumeBalok() {
        val panjangStr = inputPanjang.text.toString()
        val lebarStr = inputLebar.text.toString()
        val tinggiStr = inputTinggiBalok.text.toString()

        if (panjangStr.isEmpty() || lebarStr.isEmpty() || tinggiStr.isEmpty()) {
            Toast.makeText(this, "Masukkan panjang, lebar, dan tinggi!", Toast.LENGTH_SHORT).show()
            return
        }

        val panjang = panjangStr.toDoubleOrNull()
        val lebar = lebarStr.toDoubleOrNull()
        val tinggi = tinggiStr.toDoubleOrNull()

        if (panjang == null || lebar == null || tinggi == null) {
            Toast.makeText(this, "Masukkan angka yang valid!", Toast.LENGTH_SHORT).show()
            return
        }

        val volume = panjang * lebar * tinggi
        hasilBalok.text = "Volume Balok: $volume cm³"
    }
}