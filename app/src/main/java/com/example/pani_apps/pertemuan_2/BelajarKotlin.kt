package com.example.pani_apps.pertemuan_2

fun main() {
    println("Hai rekan-rekan?...")
    println("Selamat datang di bahasa pemograan Kontlin")

    println("=====================")

    var angka = 15
    println("Hasil dari 15 + 10 = ${angka + 10}")

    val nilaiInt = 1000
    val nilaiDouble =  100.003
    val nilaiFloat = 1000.0f

    println("Nilai Integer = $nilaiInt")
    println("Nilai Double = $nilaiDouble")
    println("Nilai Float = $nilaiFloat")

    println("=========== STRING ===========")
    val huruf = 'a'
    println("Ini penggunaan karakter '$huruf'")

    val nilaiString = "Mawar"
    println("Halo $nilaiString!\nApa Kabar?")

    println("=========== KONDISI ===========")

    val nilai = 10
    if(nilai<0)
        println("Bilangan negatif")
    else{
        if(nilai%2 == 0)
            println("Bilangan Genap")
        else
            println("Bilangan Ganjil")
    }
    println("=========== PERULANGAN ===========")
    val kampusKU: Array<String> = arrayOf("Kampis", "Politeknik", "Caltex", "Riau")
    for (kampus: String in kampusKU) {
        println(kampus)

    }
}