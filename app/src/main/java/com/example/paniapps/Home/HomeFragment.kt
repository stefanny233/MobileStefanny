package com.example.paniapps.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paniapps.AuthActivity
import com.example.paniapps.Home.pertemuan_10.TenthActivity
import com.example.paniapps.Home.pertemuan_4.FourthActivity
import com.example.paniapps.Home.pertemuan_5.FifthActivity
import com.example.paniapps.Home.pertemuan_7.SeventhActivity
import com.example.paniapps.Home.photo.PhotoAdapter
import com.example.paniapps.R
import com.example.paniapps.data.api.CatFactApiClient
import com.example.paniapps.data.api.PhotoApiClient
import com.example.paniapps.databinding.FragmentHomeBinding
import com.example.paniapps.pertemuan_9.NinthActivity
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            /*tambahkan bagian berikut*/
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }
        binding.btnToFifth.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            /*tambahkan bagian berikut*/
            startActivity(intent)
        }
        binding.btnToSeventh.setOnClickListener {
            val intent = Intent(requireContext(), SeventhActivity::class.java)
            /*tambahkan bagian berikut*/
            startActivity(intent)
        }
        binding.btnToNinth.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)
            /*tambahkan bagian berikut*/
            startActivity(intent)
        }
        binding.btnToTenth.setOnClickListener {
            val intent = Intent(requireContext(), TenthActivity::class.java)
            /*tambahkan bagian berikut*/
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {

            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->

                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()

                    startActivity(Intent(requireContext(), AuthActivity::class.java))
                    requireActivity().finish()
                }

                .setNegativeButton("Tidak", null)
                .show()
        }
        binding.btnRefresh.setOnClickListener {
            loadCatFact()
        }

        loadPhoto()
    }
    private fun loadCatFact() {
        lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                binding.tvCatFact.text = "\"${response.fact}\""
            } catch (e: Exception) {
                binding.tvCatFact.text = "Gagal mengambil fakta kucing."
            }
        }
    }
    private fun loadPhoto() {
        lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                val adapter = PhotoAdapter(photos)
                binding.rvGallery.adapter = adapter

                /** List Tampil Vertical*/
                binding.rvGallery.layoutManager = LinearLayoutManager(requireContext())

                /** List Tampil Horizontal */
                //binding.rvGallery.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

                /** List Tampil Grid */
                //binding.rvGallery.layoutManager = GridLayoutManager(requireContext(),2)

            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}