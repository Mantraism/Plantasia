package com.example.plantasiakuadrat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.plantasiakuadrat.databinding.FragmentProfileBinding
import org.koin.android.ext.android.inject


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProfileViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        val email = arguments?.getString("email") ?: ""
        Log.d("email" , "${email ?: "Email is null"}")
        readData(email)
        val navController: NavController = findNavController()
        binding.btnLogout.setOnClickListener {
            navController.navigate(R.id.action_profileFragment_to_RegisterFragment)
        }
        return view

    }

    private fun readData(email: String) {
        Log.d("readData" , "${email ?: "Email is null"}")
        viewModel.getDataProfile(email)
        displayData()
    }

    private fun displayData() {
        Log.d("Nama", "Observing profile data changes")
        with(viewModel) {
            observeProfile().observe(viewLifecycleOwner) { data ->
                // Check if 'data' is not null and contains the expected information
                if (data != null) {
                    Log.d("Nama", "Received data: ${data.nama}")
                    binding.tvUsername.text = data.nama
                    Log.d("Nama", "tvUsername.text set to: ${binding.tvUsername.text}")
                    binding.tvEmail.text = data.email
                } else {
                    Log.e("Nama", "Received null data")
                }
            }
        }
    }

}